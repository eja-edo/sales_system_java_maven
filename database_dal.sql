use master
go
drop database  if EXISTS sales_management_db;
go
CREATE DATABASE sales_management_db;

go

USE sales_management_db;
GO

-- Tạo bảng người dùng
CREATE TABLE Users (
    user_id INT IDENTITY(1,1) PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    first_name NVARCHAR(50),
    last_name NVARCHAR(50),
    email VARCHAR(100),
    password VARCHAR(255) NOT NULL,
    phone VARCHAR(15),
    address_line NVARCHAR(200),
    city NVARCHAR(50),
    province NVARCHAR(50),
    created_at DATETIME DEFAULT GETDATE(),
    updated_at DATETIME DEFAULT GETDATE()
);

-- Tạo bảng thể loại của sản phẩm
CREATE TABLE Categories (
    category_id INT IDENTITY(1,1) PRIMARY KEY,
    category_name NVARCHAR(100) NOT NULL,
    description NVARCHAR(200)
);

-- Tạo bảng sản phảm
CREATE TABLE Products (
    product_id INT IDENTITY(1,1) PRIMARY KEY,
    title NVARCHAR(100) NOT NULL,
    description NVARCHAR(3000),
    category_id INT,
	AverageRating DECIMAL(3,2) DEFAULT 0,
    created_at DATETIME DEFAULT GETDATE(),
    updated_at DATETIME DEFAULT GETDATE(),
	sex Nvarchar(10) not null check (sex in (N'Nam', N'Nữ', N'Unsex')),
	minPrice decimal(10,2),
	views int default 0,
    FOREIGN KEY (category_id) REFERENCES Categories(category_id)
);



--Tạo bảng mẫu sản phẩm kich thuoc 
CREATE TABLE ProductSize(
	product_id int,
	exemple_id int IDENTITY(1,1) primary key,
	size int,
    stock_quantity INT DEFAULT 0,
	FOREIGN KEY (product_id) REFERENCES Products(product_id)
);



-- Bảng hình ảnh sản phẩm
CREATE TABLE ProductImages (
    ID INT IDENTITY(1,1) primary key,
    ProductID INT  ,
    ImageURL VARCHAR(255) NOT NULL,
    FOREIGN KEY (ProductID) REFERENCES Products(product_id) ON DELETE CASCADE
);

-- Tạo bảng thông tin người nhận hàng
CREATE TABLE Addresses (
    address_id INT IDENTITY(1,1) PRIMARY KEY,
    user_id INT,
    full_name VARCHAR(100),
    phone VARCHAR(15),
    address_line NVARCHAR(200),
    city VARCHAR(50),
    province VARCHAR(50),
    postal_code VARCHAR(10),
    FOREIGN KEY (user_id) REFERENCES Users(user_id) ON DELETE CASCADE
);
-- Tạo bảng phiếu giảm giá
CREATE TABLE Coupons (
    coupon_id INT IDENTITY(1,1) PRIMARY KEY,
    code VARCHAR(50) NOT NULL,
    discount DECIMAL(10, 2) NOT NULL,
    expiry_date DATE,
    min_order_amount DECIMAL(10, 2)
);
create table ShippingUnits (
	shu_id int identity(1,1) primary key,
	shu_name NVARCHAR(50),
	description NVARCHAR(200)
);

-- Tạo bảng đơn hàng mua
CREATE TABLE Orders (
    order_id INT IDENTITY(1,1) PRIMARY KEY,
    user_id INT,
    order_status NVARCHAR(50) NOT NULL CHECK (order_status IN (N'Đang xử lý', N'Đã giao', N'Đã hủy', N'Đang hoàn hàng', N'Đã hoàn hàng')),
    total_price DECIMAL(10, 2) NOT NULL,
    address_id INT,
    shu_id INT,
    order_code VARCHAR(15),
    coupon_id INT,
    created_at DATETIME DEFAULT GETDATE(),
    payment_method NVARCHAR(50) NOT NULL CHECK (payment_method IN (N'Thẻ tín dụng', N'Ví điện tử', N'Chuyển khoản',N'Tiền mặt')),
    FOREIGN KEY (shu_id) REFERENCES ShippingUnits(shu_id),
    FOREIGN KEY (address_id) REFERENCES Addresses(address_id),
    FOREIGN KEY (coupon_id) REFERENCES Coupons(coupon_id),
    FOREIGN KEY (user_id) REFERENCES Users(user_id) ON DELETE CASCADE
);


-- Tạo bảng danh sách sản phẩm trong đơn hàng 
CREATE TABLE OrderItems ( 
order_id INT,exemple_id INT, 
quantity INT NOT NULL, 
price DECIMAL(10,2) NOT NULL, 
PRIMARY KEY(order_id,  exemple_id), 
FOREIGN KEY (order_id) REFERENCES Orders(order_id) ON DELETE CASCADE, 
FOREIGN KEY (exemple_id) REFERENCES ProductSize(exemple_id)
);

--shoppingcart
CREATE TABLE ShoppingCart (
    cart_id INT IDENTITY(1,1) PRIMARY KEY,
    user_id INT,
    exemple_id INT, 
    quantity INT NOT NULL default 1,
    FOREIGN KEY (user_id) REFERENCES Users(user_id) ON DELETE CASCADE,
    FOREIGN KEY (exemple_id) REFERENCES ProductSize(exemple_id)
);


-- Tạo bảng thanh toán
--CREATE TABLE Payments (
--    payment_id INT IDENTITY(1,1) PRIMARY KEY,
--    order_id INT,
--    payment_method NVARCHAR(50) NOT NULL CHECK (payment_method IN (N'Thẻ tín dụng', N'Ví điện tử', N'Chuyển khoản',N'Tiền mặt')),
--    payment_status NVARCHAR(50) NOT NULL CHECK (payment_status IN (N'Đã thanh toán', N'Chưa thanh toán')),
--    amount DECIMAL(10, 2) NOT NULL,
--    payment_date DATETIME DEFAULT GETDATE(),
--    FOREIGN KEY (order_id) REFERENCES Orders(order_id) ON DELETE CASCADE
--);

-- Tạo bảng Reviews
CREATE TABLE Reviews (
    review_id INT IDENTITY(1,1) PRIMARY KEY,
    user_id INT,
    product_id INT,
    rating INT CHECK (rating >= 1 AND rating <= 5),
    comment NVARCHAR(1000),
    created_at DATETIME DEFAULT GETDATE(),
    FOREIGN KEY (user_id) REFERENCES Users(user_id) ON DELETE SET NULL,
    FOREIGN KEY (product_id) REFERENCES Products(product_id) 
);

-- Tạo bảng Shipping
--CREATE TABLE Shipping (
--    shipping_id INT IDENTITY(1,1) PRIMARY KEY,
--    order_id INT,
--    tracking_number VARCHAR(50),
--    shipping_status NVARCHAR(50) NOT NULL CHECK (shipping_status IN (N'Đang giao', N'Đã giao', N'Gặp vấn đề')),
--    shipping_date DATETIME DEFAULT GETDATE(),
--    FOREIGN KEY (order_id) REFERENCES Orders(order_id)
--);

-- Tạo bảng yêu thích
CREATE TABLE Favorites (
    favorite_id INT IDENTITY(1,1) PRIMARY KEY,
    user_id INT,
    product_id INT,
    FOREIGN KEY (user_id) REFERENCES Users(user_id) ON DELETE CASCADE,
    FOREIGN KEY (product_id) REFERENCES Products(product_id) 
);

-- Tạo bảng thông báo
CREATE TABLE Notifications (
    notification_id INT IDENTITY(1,1) PRIMARY KEY,
    user_id INT,
    message NVARCHAR(2000),
    created_at DATETIME DEFAULT GETDATE(),
    is_read BIT DEFAULT 0,
    FOREIGN KEY (user_id) REFERENCES Users(user_id) ON DELETE CASCADE
);
--user1
INSERT INTO Users (username, first_name, last_name, email, password, phone, address_line, city, province)
VALUES 
('duongbill', 'Duong', 'Nguyen', 'duongbill@gmail.com', '1', '0985082004', 'Dich Vong', 'Cau Giay', 'Ha Noi'),
('duyanh', 'Anh', 'Vu', 'duongbill1@gmail.com', '1', '0985082005', 'Trung Hoa', 'Cau Giay', 'Ha Noi'),
('kimlien', 'Lien', 'Vo', 'duongbill2@gmail.com', '1', '0985082006', 'Xuan Thuy', 'Cau Giay', 'Ha Noi');

--cate2
INSERT INTO Categories (category_name, description)
VALUES 
(N'Trang sức cưới ', N'Các sản phẩm trang sức như vòng cổ, nhẫn, bông tai'),

(N'Đồng hồ ', N'Các loại đồng hồ xa sỉ trên toàn thế giới'),

(N'Quà tặng ', N'Những món quà đầy ý nghĩa dành tặng cho gia đình người thân trong những ngày quan trọng '),

(N'Thương hiệu ', N'Những dòng sản phẩm của những brand hàng đầu trong ngàng công nghiệp trang sức'),

(N'Bộ siêu tập ', N'Bộ siêu tập với những dòng sản phẩm ');

--prodcut3
INSERT INTO Products (title, description, category_id, AverageRating, sex, minPrice, views)
VALUES 
(N'Nhẫn cưới nam Kim cương Vàng 18K DAL DD00Y003449', 
N'Vượt qua hành trình mài giũa dưới bàn tay của các nghệ nhân,<br>
kim cương gắn liền với biểu tượng của tình yêu thủy chung, son sắt.<br>
Với sắc vàng 18K rực rỡ cùng vẻ đẹp lấp lánh và tinh khiết của kim cương, <br>
DAL mang đến nhẫn vàng hiện đại nhưng vẫn giữ được nét truyền thống vốn có.<br>
Không chỉ có vai trò là vật đính ước thiêng liêng, nhẫn cưới kim cương còn<br>
thể hiện cá tính và phong cách của mỗi cặp đôi. <br>
Tại DAL, các cặp đôi luôn có thể sở hữu những thiết kế nhẫn<br> 
cưới kim cương vừa hợp lí về tài chính, vừa đẹp về mẫu mã.',
(SELECT category_id FROM Categories WHERE category_name = N'Trang sức cưới'), 5.0, N'Nam', 10468000.00, 100),

(N'Cặp nhẫn cưới Vàng trắng 14K DAL Trầu cau 02804-11767',
N'Vượt qua hành trình mài giũa dưới bàn tay của các nghệ nhân,<br>
kim cương gắn liền với biểu tượng của tình yêu thủy chung, son sắt. 
Với sắc vàng 14K rực rỡ cùng vẻ đẹp lấp lánh và tinh khiết của kim cương, <br>
DAL mang đến nhẫn vàng hiện đại nhưng vẫn giữ được nét truyền thống vốn có.<br>
Không chỉ có vai trò là vật đính ước thiêng liêng, nhẫn cưới kim cương<br>
còn thể hiện cá tính và phong cách của mỗi cặp đôi. <br>
Tại DAL, các cặp đôi luôn có thể sở hữu những thiết kế nhẫn <br>
cưới kim cương vừa hợp lí về tài chính, vừa đẹp về mẫu mã.', 
(SELECT category_id FROM Categories WHERE category_name = N'Trang sức cưới '), 4.8, N'Unsex', 15366000.00, 150),

(N'Dây cổ cưới Vàng 24K DAL 0000Y000423',
N'Tôn vinh vẻ đẹp kiêu sa của quý cô, chiếc dây cổ vàng 24K chắc chắn<br>
sẽ là điểm nhấn cho ngày trọng đại này. <br>
Sức hút riêng của thiết kế được kết tạo từ thiết kế cực kì duyên dáng với<br>
điểm nhấn cách điệu tinh xảo, tạo nên sản phẩm tinh tế chinh phục mọi ánh nhìn.<br>
PNJ tự hào mang đến những mẫu trang sức tinh tế, giúp bạn có nhiều sự lựa chọn <br>
cho phong cách của mình. <br>
Bằng tất thảy sự trân trọng và cảm xúc dành riêng cho phái đẹp, <br>
từng chi tiết đều được các nghệ nhân PNJ nâng niu và cẩn trọng, đặt<br>
trọn vào những thiết kế trang sức xứng tầm.', 
(SELECT category_id FROM Categories WHERE category_name = N'Trang sức cưới '), 4.8, N'Unsex', 9793000.00, 150),

(N'Bông tai Kim cương Vàng Trắng 14K DAL Trầu Cau DDDDW004320', 
N'Mang vẻ đẹp hoàn hảo, đôi bông tai với điểm nhấn kim cương sẽ<br>
là “trợ thủ” nâng tầm nhan sắc của mọi cô nàng ưa chuộng<br>
phong cách hiện đại và thanh lịch.', 
(SELECT category_id FROM Categories WHERE category_name = N'Trang sức cưới '), 4.9, N'Unsex', 55813000.00, 150),

(N'Nhẫn cưới Kim cương Vàng Trắng 14K DAL DDDDW009976',
N'Kim cương đã đẹp, trang sức kim cương lại càng mang sức <br>
hấp dẫn khó cưỡng.<br>
Sự kết hợp mới mẻ này chắc chắn sẽ tạo nên dấu ấn thời trang <br>
hiện đại và giúp quý cô trở nên nổi bật,tự tin và thu<br>
hút sự ngưỡng mộ của mọi người', 
(SELECT category_id FROM Categories WHERE category_name = N'Trang sức cưới '), 5.0, N'Nữ', 39451000.00, 100),

(N'Nhẫn cưới Kim cương Vàng Trắng 14K DAL DDDDW011925',
N'Kim cương đã đẹp, trang sức kim cương lại càng mang <br>
sức hấp dẫn khó cưỡng.<br>
Sự kết hợp mới mẻ này chắc chắn sẽ tạo nên dấu ấn thời trang<br>
hiện đại và giúp quý cô trở nên nổi bật,<br>
tự tin và thu hút sự ngưỡng mộ của mọi người', 
(SELECT category_id FROM Categories WHERE category_name = N'Trang sức cưới '), 5.0, N'Nữ', 17691000.00, 100),

(N'Nhẫn cưới Kim cương Vàng Trắng 14K DAL Trầu Cau DDDDW011762', N'
Tôn vinh vẻ đẹp và sự chín muồi của tình yêu đích thực,<br>
DAL cùng đôi lứa sẵn sàng cho hành trình hôn nhân của các bạn', 
(SELECT category_id FROM Categories WHERE category_name = N'Trang sức cưới '), 4.6, N'Nữ', 43564000.00, 100),

(N'Nhẫn Kim cương Vàng 18K DAL DDDDY000790', N'
Không chỉ có vai trò là vật đính ước thiêng liêng,<br>
nhẫn cưới kim cương còn thể hiện cá tính và phong cách của mỗi cặp đôi.', 
(SELECT category_id FROM Categories WHERE category_name = N'Trang sức cưới '), 4.8, N'Nữ', 20440800.00, 100),

(N'Nhẫn cưới nam Kim cương Vàng Trắng 14K DAL DD00W004085', 
N'Kim cương vốn là món trang sức mang đến niềm kiêu hãnh <br>
và cảm hứng thời trang bất tận.<br>
Sở hữu riêng cho mình món trang sức kim cương chính là điều mà ai cũng mong muốn.', 
(SELECT category_id FROM Categories WHERE category_name = N'Trang sức cưới '), 3.8, N'Nam', 26471000.00, 100),

(N'Nhẫn cưới Kim cương Vàng 18K DAL DD00Y000326',
N'Kim cương vốn là món trang sức mang đến niềm kiêu hãnh<br>
và cảm hứng thời trang bất tận.<br>
Sở hữu riêng cho mình món trang sức kim cương chính là điều mà ai cũng mong muốn.', 
(SELECT category_id FROM Categories WHERE category_name = N'Trang sức cưới '), 4.7, N'Unsex', 7529000.00, 100),


(N'Nhẫn cưới Vàng 24K DAL Trầu Cau 0000Y003194',
N'Ưu tiên hàng đầu cho các nàng dâu mới, PNJ mang đến những chiếc<br>
nhẫn trong BST Trầu Cau cưới sở hữu thiết kế dựa trên lá trầu quả<br>
cau. Chế tác từ vàng 24K (99% vàng nguyên chất), với đặc tính mềm<br>
nên thông thường những món trang sức này có kiểu dáng bắt mắt và <br>
cầu kỳ.<br>
Lá trầu bên ngoài được tạo nét theo cánh phượng uyển chuyển bao<br>
bọc bên trong là quả cau, thể hiện sự hòa quyện giữa miếng trầu<br>
và cánh phượng vừa mang đậm tính văn hóa bản sắc dân tộc vừa<br>
thể hiện được tình cảm sắt son của đôi lứa.', 
(SELECT category_id FROM Categories WHERE category_name = N'Trang sức cưới '), 5.0, N'Unsex', 17529000.00, 100),

(N'Bông tai Kim cương Vàng trắng 14K DAL DDDDW000182', 
N'Kim cương được xem là biểu tượng của sự quyền lực, giàu sang và <br>
quý phái,do đó nó được sử dụng để tạo nên các tuyệt tác trang sức<br>
kim cương tinh tế. <br>
Sự sáng tạo mạnh mẽ của các nhà thiết kế của DAL được phô diễn thông<br>
qua đôi bông tai với vẻ đẹp đẳng cấp và thời thượng.', 
(SELECT category_id FROM Categories WHERE category_name = N'Trang sức cưới '), 4.8, N'Unsex', 15629000.00, 100),

(N'Bông tai cưới Vàng 24K DAL 0000Y000113',
N'Đối với người phương Đông, trang sức cưới mang ý nghĩa tinh thần, <br>
chúc phúc cho cuộc sống lứa đôi mà cả hai bên dòng họ gửi đến đôi <br>
vợ chồng trẻ, tượng trưng cho hạnh phúc viên mãn, kỷ vật minh <br>
chứng tình yêu vĩnh cửu.', 
(SELECT category_id FROM Categories WHERE category_name = N'Trang sức cưới '), 4.9, N'Unsex', 15549000.00, 100),

(N'Bông tai cưới Vàng 24K DAL Lan Mùa Hạ 0000Y000071', 
N'Ưu tiên hàng đầu cho các nàng dâu mới, DAL mang đến những đôi<br>
bông tai sở hữu thiết kế vừa hiện đại vừa cổ điển. <br>
Chế tác từ vàng 24K (99% vàng nguyên chất), với đặc tính mềm nên <br>
thông thường những món trang sức này có kiểu dáng bắt mắt và cầu kỳ.', 
(SELECT category_id FROM Categories WHERE category_name = N'Trang sức cưới '), 4.9, N'Unsex', 13449000.00, 100),

(N'Bông tai cưới Vàng 24K DAL Duyên Phượng Tình Hồng 0000Y000102', 
N'Ưu tiên hàng đầu cho các nàng dâu mới, DAL mang đến những đôi bông<br>
tai sở hữu thiết kế vừa hiện đại vừa cổ điển. <br>
Chế tác từ vàng 24K (99% vàng nguyên chất), với đặc tính mềm nên <br>
thông thường những món trang sức này có kiểu dáng bắt mắt và cầu kỳ.', 
(SELECT category_id FROM Categories WHERE category_name = N'Trang sức cưới '), 5.0, N'Unsex', 28449000.00, 100),

(N'Bông tai cưới Vàng 24K DAL 0000Y003038', 
N'Ưu tiên hàng đầu cho các nàng dâu mới, DAL mang đến những đôi <br>
bông tai sở hữu thiết kế vừa hiện đại vừa cổ điển. <br>
Chế tác từ vàng 24K (99% vàng nguyên chất), với đặc tính mềm <br>
nên thông thường những món trang sức này có kiểu dáng bắt mắt và cầu kỳ.', 
(SELECT category_id FROM Categories WHERE category_name = N'Trang sức cưới '), 4.9, N'Unsex', 37449000.00, 100),

(N'Bông tai cưới Vàng 24K DAL Hạnh Phúc 0000Y000083',
N'Ưu tiên hàng đầu cho các nàng dâu mới, DAL mang đến những<br>
đôi bông tai sở hữu thiết kế vừa hiện đại vừa cổ điển. <br>
Chế tác từ vàng 24K (99% vàng nguyên chất), với đặc tính mềm<br>
nên thông thường những món trang sức này có kiểu dáng bắt mắt và cầu kỳ.', 
(SELECT category_id FROM Categories WHERE category_name = N'Trang sức cưới '), 4.8, N'Unsex', 56449000.00, 100),

(N'Bông tai cưới Vàng 18K đính đá ECZ DAL Trầu Cau XMXMY006013',
N'Ưu tiên hàng đầu cho các nàng dâu mới, DAL mang đến những đôi bông tai<br>
sở hữu thiết kế vừa hiện đại vừa cổ điển. <br>
Chế tác từ vàng 24K (99% vàng nguyên chất), với đặc tính mềm nên thông<br>
thường những món trang sức này có kiểu dáng bắt mắt và cầu kỳ.', 
(SELECT category_id FROM Categories WHERE category_name = N'Trang sức cưới '), 4.9, N'Unsex', 42449000.00, 100),

(N'Bông tai cưới Vàng 24K DAL Trầu cau 0000Y002680', 
N'Ưu tiên hàng đầu cho các nàng dâu mới, DAL mang đến những đôi bông tai<br>
sở hữu thiết kế vừa hiện đại vừa cổ điển. <br>
Chế tác từ vàng 24K (99% vàng nguyên chất), với đặc tính mềm nên thông <br>
thường những món trang sức này có kiểu dáng bắt mắt và cầu kỳ.', 
(SELECT category_id FROM Categories WHERE category_name = N'Trang sức cưới '), 5.0, N'Unsex', 20449000.00, 100),

(N'Bông tai cưới Vàng trắng 10K đính đá ECZ DAL Bạch Khổng Tước XMXMW001971',
N'Đôi bông tai được các nghệ nhân kim hoàn khoác lên vẻ ngoài đầy tinh <br>
xảo bởi được chế tác từ vàng 10K với 41,6% vàng nguyên chất.<br>
Và những viên đá ECZ đạt tiêu chuẩn cao nhất về chất lượng cùng<br>
độ chính xác trong từng giác cắt, được đính một cách khéo léo trên đôi khuyên tai càng làm
cho sản phẩm trở nên rực rỡ và kiêu sa.', 
(SELECT category_id FROM Categories WHERE category_name = N'Trang sức cưới '), 5.0, N'Unsex', 30449000.00, 100),



--watch
(N'Đồng hồ Disney & Marvel Nam M-6069R Dây Cao Su 50 mm', N'Đồng hồ nhượng quyền Disney', (SELECT category_id FROM Categories WHERE category_name = N'Đồng hồ'), 5.0, N'Nam', 4750000.00, 300),
(N'Đồng hồ Disney & Marvel Nam M-6072B Dây Cao Su 50 mm', N'Đồng hồ nhượng quyền Disney', (SELECT category_id FROM Categories WHERE category_name = N'Đồng hồ'), 4.8, N'Nam', 4750000.00, 250),
(N'Đồng Hồ Michael Kors Nữ MK7197 Dây Thép Không Gỉ 33 mm', 
N'Đồng hồ sử dụng mặt kính cứng và có độ trong suốt cao, <br>
ít trầy xước khi có va chạm nhẹ.<br>
Có thể nói thương hiệu thời trang Michael Kors nói chung và đồng<br>
hồ Michael Kors nói riêng đã đốn tim bao nhiêu nàng bởi vẻ <br>
đẹp hiện đại, sang trọng
', (SELECT category_id FROM Categories WHERE category_name = N'Đồng hồ'), 4.8, N'Nữ', 8020000.00, 250),
(N'Đồng Hồ Citizen Nữ EM0860-51D Dây Thép Không Gỉ 25 mm', 
N'Với thiết kế mang hơi hướng cổ điển, chiếc đồng hồ Citizen mang<br>
lại sự thanh lịch và sang trọng cho người đeo. <br>
Đồng hồ Citizen bộ máy Eco-Drive là một loại đồng hồ đặc biệt với <br>
công nghệ tiên tiến và thân thiện với môi trường
', (SELECT category_id FROM Categories WHERE category_name = N'Đồng hồ'), 4.8, N'Nữ', 10985000.00, 240),
(N'Đồng Hồ Citizen Nam NH8390-71L Dây Thép Không Gỉ 40 mm', 
N'Đây sẽ là một món quà tuyệt vời để tặng cho bạn bè,<br>
người thân hoặc để tự thưởng cho bản thân để thể hiện phong<br>
cách thời trang đẳng cấp của mình.', 
(SELECT category_id FROM Categories WHERE category_name = N'Đồng hồ'), 4.8, N'Nam', 8177000.00, 250),
(N'Đồng Hồ Fossil Nam ME3061 Dây Da 44mm', 
N'Đồng hồ nam Fossil vẫn luôn được yêu thích ở Dòng máy<br>
Automatic - các nhà chế tác vẫn giữ nguyên thiết kế <br>
truyền thống vintage của Fossil
', (SELECT category_id FROM Categories WHERE category_name = N'Đồng hồ'), 5.0, N'Nam', 7240000.00, 300),
(N'Đồng Hồ Citizen Nữ EM0502-86P Dây Thép Không Gỉ 32mm',
N'Với thiết kế mang hơi hướng cổ điển, chiếc đồng hồ Citizen <br>
mang lại sự thanh lịch và sang trọng cho người đeo. <br>
Đồng hồ Citizen bộ máy Eco-Drive là một loại đồng hồ đặc<br>
biệt với công nghệ tiên tiến và thân thiện với môi trường
', (SELECT category_id FROM Categories WHERE category_name = N'Đồng hồ'), 4.8, N'Nữ', 4263000.00, 240),
(N'Đồng Hồ Michael Kors Nữ MK3640 Dây Thép Không Gỉ 36mm',
N'Được trang bị bộ máy quartz cùng vẻ đẹp cổ điển,<br>
chiếc đồng hồ Michael Kors  sẽ là phụ kiện giúp phái đẹp <br>
trông thật tinh tế và thu hút. <br>
Bộ vỏ bên ngoài của đồng hồ được chế tác từ thép không<br>
gỉ bền bỉ với thời gian.
', (SELECT category_id FROM Categories WHERE category_name = N'Đồng hồ'), 4.8, N'Nữ', 9100000.00, 240),
(N'Đồng Hồ Fossil Nữ ES5192 Dây Thép Không Gỉ 37 mm',
N'Được trang bị bộ máy quartz vừa bền, vừa khỏe lại hiện <br>
đại bậc nhất nên độ sai số thấp, <br>
độ chính xác cao hơn nhiều lần so với những chiếc đồng<br>
hồ khác, chiếc đồng hồ Fossil sẽ là phụ kiện giúp phái <br>
trông thật thu hút.
', (SELECT category_id FROM Categories WHERE category_name = N'Đồng hồ'), 4.8, N'Nữ', 3423000.00, 240),
(N'Đồng Hồ Nam Citizen NJ0150-81X Dây Thép Không Gỉ 40 mm', 
N'Đây sẽ là một món quà tuyệt vời để tặng cho bạn bè,<br>
người thân hoặc để tự thưởng cho bản thân để thể hiện<br>
phong cách thời trang đẳng cấp của mình.', 
(SELECT category_id FROM Categories WHERE category_name = N'Đồng hồ'), 4.8, N'Nam', 12185000.00, 250),
(N'Đồng hồ Rado True Square Unisex R27073712 Dây Ceramic 38 mm',
N'Đây sẽ là một món quà tuyệt vời để tặng cho bạn bè,<br>
người thân hoặc để tự thưởng cho bản thân để thể hiện <br>
phong cách thời trang đẳng cấp của mình.', 
(SELECT category_id FROM Categories WHERE category_name = N'Đồng hồ'), 4.9, N'Nam', 18185000.00, 290),

(N'Đồng hồ Tissot Nam PRX T137.410.17.051.00 Dây Cao Su 40 mm', 
N'Đây sẽ là một món quà tuyệt vời để tặng cho bạn bè,<br>
người thân hoặc để tự thưởng cho bản thân để thể hiện<br>
phong cách thời trang đẳng cấp của mình.', 
(SELECT category_id FROM Categories WHERE category_name = N'Đồng hồ'), 4.9, N'Nam', 21185000.00, 200),

(N'Đồng hồ Tissot Nam PRX Powermatic 80 T137.407.11.351.00 Dây Kim Loại 40 mm',
N'Đây sẽ là một món quà tuyệt vời để tặng cho bạn bè,<br>
người thân hoặc để tự thưởng cho bản thân để thể hiện <br>
phong cách thời trang đẳng cấp của mình.', 
(SELECT category_id FROM Categories WHERE category_name = N'Đồng hồ'), 4.8, N'Nam', 20185000.00, 300),

(N'Đồng hồ Longines La Grande Nữ L4.209.4.81.6 Dây Kim Loại 24 mm', 
N'Là phiên bản mới nhất nằm trong bộ sưu tập LA GRANDE<br>
CLASSIQUE DE LONGINES- Đại diện cho phong cách quyến <br>
rũ của phái đẹp, nổi bật với 12 viên kim cương đính trên<br>
mặt số.', 
(SELECT category_id FROM Categories WHERE category_name = N'Đồng hồ'), 4.9, N'Nữ', 15185000.00, 340),

(N'Đồng hồ Longines Master Nam L2.919.4.92.6 Dây Kim Loại 42 mm',
N'Là một trong những mẫu đồng hồ bán chạy nhất thuộc bộ sưu tập <br>
LONGINES MASTER COLLECTION - KIỆT TÁC THỜI GIAN ĐẾN TỪ THỤY SỸ.<br>
Với những thiết kế thuộc bộ sưu tập Longines Master ra mắt từ<br>
năm 2005, vẻ đẹp vượt thời gian được minh chứng qua từng chi<br>
tiết dù nhỏ nhất.', 
(SELECT category_id FROM Categories WHERE category_name = N'Đồng hồ'), 4.8, N'Nam', 45185000.00, 320),

(N'Đồng hồ Longines Master Nam L2.893.4.77.3 Dây Da 42 mm', 
N'Đây sẽ là một món quà tuyệt vời để tặng cho bạn bè,<br>
người thân hoặc để tự thưởng cho bản thân để thể hiện<br>
phong cách thời trang đẳng cấp của mình.', 
(SELECT category_id FROM Categories WHERE category_name = N'Đồng hồ'), 4.8, N'Nam', 40185000.00, 260),

(N'Đồng hồ Calvin Klein Nam 25200293 Dây Kim Loại 44 mm', 
N'Đây sẽ là một món quà tuyệt vời để tặng cho bạn bè,<br>
người thân hoặc để tự thưởng cho bản thân để thể hiện phong <br>
cách thời trang đẳng cấp của mình.', 
(SELECT category_id FROM Categories WHERE category_name = N'Đồng hồ'), 4.9, N'Nam', 65185000.00, 280),

(N'Đồng hồ Calvin Klein Nam 25200303 Dây Kim Loại 44.3 mm', 
N'Đây sẽ là một món quà tuyệt vời để tặng cho bạn bè,<br>
người thân hoặc để tự thưởng cho bản thân để thể hiện phong <br>
cách thời trang đẳng cấp của mình.', 
(SELECT category_id FROM Categories WHERE category_name = N'Đồng hồ'), 4.9, N'Nam', 55185000.00, 380),

(N'Đồng hồ Rado Centrix Nữ R30029902 Dây Kim Loại 35 mm',
N'Đây sẽ là một món quà tuyệt vời để tặng cho bạn bè,<br>
người thân hoặc để tự thưởng cho bản thân để thể hiện <br>
phong cách thời trang đẳng cấp của mình.', 
(SELECT category_id FROM Categories WHERE category_name = N'Đồng hồ'), 4.9, N'Nữ', 50185000.00, 310),

(N'Đồng hồ Rado Centrix Nữ R30248902 Dây Kim Loại 33 mm',
N'Đây sẽ là một món quà tuyệt vời để tặng cho bạn bè,<br>
người thân hoặc để tự thưởng cho bản thân để thể hiện <br>
phong cách thời trang đẳng cấp của mình.', 
(SELECT category_id FROM Categories WHERE category_name = N'Đồng hồ'), 4.9, N'Nữ', 24185000.00, 350),

(N'Đồng hồ Rado Centrix Nữ R30037742 Dây Kim Loại 35 mm', 
N'Đây sẽ là một món quà tuyệt vời để tặng cho bạn bè,<br>
người thân hoặc để tự thưởng cho bản thân để thể hiện <br>
phong cách thời trang đẳng cấp của mình.', 
(SELECT category_id FROM Categories WHERE category_name = N'Đồng hồ'), 4.9, N'Nữ', 36185000.00, 370),




--gift
(N'Lắc tay Vàng 14K đính đá CZ Disney|DAL Mickey XMXMY061792',
N'Disney|DAL xin giới thiệu đến bạn phiên bản trang sức đặc <br>
sắc với một chế tác từ chất liệu vàng 14K, điểm xuyến bởi các <br>
chi tiết đậm chất "Disney" và đầy tính sáng tạo.', 
(SELECT category_id FROM Categories WHERE category_name = N'Quà tặng'), 5.0, N'Nữ', 12450000.00, 200),

(N'Bông tai Bạc đính ngọc trai DALSilver PF00W000024',
N'Dù ở lứa tuổi nào, theo phong cách cổ điển hay hiện đại thì <br>
sắc màu của những viên đá ECZ màu trắng vẫn luôn biết<br>
"chiều lòng" các tín đồ thời trang',
(SELECT category_id FROM Categories WHERE category_name = N'Quà tặng'), 4.9, N'Nữ', 397500.00, 150),

(N'Bông tai Vàng trắng 10K đính đá ECZ DAL XMXMW002314', 
N'Mang vẻ đẹp hoàn hảo không thua kém kim cương, đôi <br>
bông tai với điểm nhấn đá ECZ sẽ là <br>
“trợ thủ” nâng tầm nhan sắc của mọi cô nàng ưa chuộng <br>
phong cách hiện đại và thanh lịch.',
(SELECT category_id FROM Categories WHERE category_name = N'Quà tặng'), 4.6, N'Nữ', 2910000.00, 150),


(N'Mặt dây chuyền Vàng Trắng 10K đính đá ECZ STYLE by DAL Sunlover XMXMW002476', 
N'Đặc biệt, những cô nàng công sở còn có thể diện cho mình một <br>
số phụ kiện cùng kiểu để tăng thêm tính thời trang, tạo điểm <br>
nhấn nổi bật. Và chắc chắn rằng, đồng nghiệp sẽ trầm trồ về<br>
gu thời trang chất lừ, thu hút và vẫn cực thanh lịch của nàng.',
(SELECT category_id FROM Categories WHERE category_name = N'Quà tặng'), 4.8, N'Nữ', 1700000.00, 150),

(N'Bông tai Vàng Trắng 10K đính đá ECZ STYLE by DAL Sunlover XM00W001263', 
N'Mang vẻ đẹp hoàn hảo không thua kém kim cương, đôi bông tai<br>
trong BST Sunlover với điểm nhấn đá ECZ sẽ là “trợ thủ” <br>
nâng tầm nhan sắc của mọi cô nàng ưa chuộng phong cách <br>
hiện đại và thanh lịch.',
(SELECT category_id FROM Categories WHERE category_name = N'Quà tặng'), 4.8, N'Nữ', 3200000.00, 150),

(N'Bông tai Vàng trắng 14K đính đá synthetic Disney|DAL Cinderella ZT00W000014', 
N'Mang vẻ đẹp hoàn hảo không thua kém kim cương, đôi bông <br>
tai trong BST Sunlover với điểm nhấn đá ECZ sẽ là “trợ thủ” <br>
nâng tầm nhan sắc của mọi cô nàng ưa chuộng phong cách<br>
hiện đại và thanh lịch.',
(SELECT category_id FROM Categories WHERE category_name = N'Quà tặng'), 4.1, N'Nữ', 6800000.00, 150),

(N'Bông tai trẻ em Bạc DALSilver 0000W060048',
N'Đặc biệt hơn, đôi bông tai sẽ trở nên ý nghĩa hơn<br>
khi trở thành món quà ghi dấu yêu thương<br>
vào những dịp quan trọng. Đây chắc chắn sẽ là thứ giúp <br>
bạn gắn kết những khoảnh khắc đáng nhớ với mình hoặc người thương.',
(SELECT category_id FROM Categories WHERE category_name = N'Quà tặng'), 4.7, N'Nữ', 580000.00, 112),

(N'Bông tai trẻ em Bạc đính đá DALSilver XMXMW060171', 
N'Đặc biệt hơn, đôi bông tai sẽ trở nên ý nghĩa hơn khi<br>
trở thành món quà ghi dấu yêu thương<br>
vào những dịp quan trọng. Đây chắc chắn sẽ là thứ giúp bạn<br>
gắn kết những khoảnh khắc đáng nhớ với mình hoặc người thương.',
(SELECT category_id FROM Categories WHERE category_name = N'Quà tặng'), 4.8, N'Nữ', 745000.00, 112),

(N'Bông tai trẻ em Bạc DALSilver 0000W060046', 
N'Đặc biệt hơn, đôi bông tai sẽ trở nên ý nghĩa hơn<br>
khi trở thành món quà ghi dấu yêu thương<br>
vào những dịp quan trọng. Đây chắc chắn sẽ là thứ giúp<br>
bạn gắn kết những khoảnh khắc đáng nhớ với mình hoặc người thương.',
(SELECT category_id FROM Categories WHERE category_name = N'Quà tặng'), 4.2, N'Nữ', 645000.00, 120),

(N'Nhẫn trẻ em Bạc DALSilver 0000W060019',
N'Chiếc nhẫn DALSilver sở hữu một thiết kế trẻ trung,<br>
thể hiện vẻ đẹp đáng yêu của những nàng công chúa nhỏ của ba mẹ. <br>
Sự đính kết và sắp xếp những điểm nhấn một cách hoàn <br>
hảo mang đến vẻ đẹp của sự phá cách, cá tính và thời thượng <br>
cho sản phẩm.',
(SELECT category_id FROM Categories WHERE category_name = N'Quà tặng'), 4.9, N'Nữ', 291000.00, 120),
--
(N'Bông tai Kim cương Vàng trắng 14K DAL DDDDW060268',
N'Đôi bông tai được chế tác từ vàng 14K và sở hữu kiểu dáng <br>
nhỏ xinh, phù hợp với những quý cô ưa chuộng<br>
phong cách sang trọng. Đặc biệt hơn nữa, đôi bông tai<br>
sở hữu điểm nhấn Kim cương tạo nên vẻ đẹp tinh tế, tôn<br>
lên vẻ đẹp dịu dàng, quý phái cho người đeo.',
(SELECT category_id FROM Categories WHERE category_name = N'Quà tặng'), 4.9, N'Nữ', 2391000.00, 190),

(N'Bông tai Kim cương Vàng trắng 14K DAL DDDDW060268', 
N'Đôi bông tai được chế tác từ vàng 14K và sở hữu kiểu<br>
dáng nhỏ xinh, phù hợp với những quý cô ưa chuộng<br>
phong cách sang trọng. Đặc biệt hơn nữa, đôi bông tai <br>
sở hữu điểm nhấn Kim cương tạo nên vẻ đẹp tinh tế, tôn <br>
lên vẻ đẹp dịu dàng, quý phái cho người đeo.',
(SELECT category_id FROM Categories WHERE category_name = N'Quà tặng'), 4.9, N'Nữ', 3391000.00, 190),

(N'Bông tai Vàng 18K đính đá Ruby DAL Family Infinity RBXMC000008',
N'Một chiếc nhẫn hay đôi bông tai trong BST Family Infinity<br>
sẽ là những phụ kiện ưu tiên hàng đầu<br>
của các nàng. Mẫu trang sức tôn lên sự dịu dàng, nhưng <br>
cũng không kém phần nổi bật, DAL tin chắc rằng, quý cô<br>
sẽ trông thật sự nổi bật và thu hút sự chú ý xung quanh.',
(SELECT category_id FROM Categories WHERE category_name = N'Quà tặng'), 4.8, N'Nữ', 1471000.00, 290),

(N'Bông tai Vàng 10K STYLE by DAL 0000Y002594', 
N'Với mong muốn gửi gắm những cảm xúc yêu thương đến nàng<br>
thông qua những món trang sức nói chung và bông tai vàng<br>
nói riêng, STYLE By DAL tin rằng đây sẽ là món quà ý nghĩa<br>
nhất dành tặng cho người phụ nữ mà bạn yêu thương.',
(SELECT category_id FROM Categories WHERE category_name = N'Quà tặng'), 4.9, N'Nữ', 2571000.00, 390),

(N'Hạt charm xỏ trẻ em DIY DALSilver chữ sweet baby 0000H060002', 
N'Xu hướng D.I.Y hiện nay vẫn được các cô gái ưa chuộng bởi <br>
cảm giác “Do It Yourself”, thể hiện được cá tính<br>
của mỗi người và Charm DALSilver vẫn đề cao tính sáng tạo<br>
theo xu hướng này trong phong cách của các cô nàng.',
(SELECT category_id FROM Categories WHERE category_name = N'Quà tặng'), 4.9, N'Nữ', 391000.00, 180),

(N'Hạt charm xỏ trẻ em DIY DALSilver chữ baby xanh 00XMW060025',
N'Xu hướng D.I.Y hiện nay vẫn được các nhiều bạn trẻ ưa chuộng<br>
bởi cảm giác “Do It Yourself”, thể hiện được<br>
cá tính của mỗi người và Charm DALSilver vẫn đề cao tính sáng <br>
tạo theo xu hướng này trong phong cách của mỗi người.',
(SELECT category_id FROM Categories WHERE category_name = N'Quà tặng'), 4.9, N'Nữ', 491000.00, 280),

(N'Mặt dây chuyền Kim cương Vàng trắng 14K DAL DDDDW000924', 
N'DAL xin giới thiệu một món trang sức đặc biệt, giúp nàng thu<br>
hút mọi sự chú ý xung quanh với <br>
chiếc mặt dây chuyền vàng 14K sở hữu chi tiết Kim cương đính<br>
một cách tỉ mỉ trên chất liệu vàng 14K.',
(SELECT category_id FROM Categories WHERE category_name = N'Quà tặng'), 4.9, N'Nữ', 9491000.00, 380),

(N'Mặt dây chuyền Vàng 14K đính đá CZ DAL ❤️ HELLO KITTY XM00C060002',
N'Sở hữu kiểu dáng lấy cảm hứng từ hình ảnh Hello Kitty như <br>
dấu ấn cô bé đáng yêu, chiếc nơ dễ thương, vườn hoa ngát<br>
hương,... sản phẩm sẽ làm nổi bật vẻ đẹp đáng yêu của nàng.',
(SELECT category_id FROM Categories WHERE category_name = N'Quà tặng'), 4.9, N'Nữ', 3491000.00, 280),

(N'Mặt dây chuyền Kim cương Vàng trắng 14K DAL DDDDW000923',
N'DAL xin giới thiệu một món trang sức đặc biệt, giúp nàng thu <br>
hút mọi sự chú ý xung quanh với chiếc mặt dây chuyền vàng<br>
14K sở hữu chi tiết Kim cương đính<br>
một cách tỉ mỉ trên chất liệu vàng 14K.',
(SELECT category_id FROM Categories WHERE category_name = N'Quà tặng'), 4.8, N'Nữ', 9491000.00, 380),

(N'Bông tai Kim Tiền Vàng trắng Ý 18K DAL 0000W002163',
N'Những sản phẩm vàng Ý tinh tế từ DAL đã và đang khuấy<br>
động xu hướng thời trang hiện nay. <br>
Chọn ngay item để tôn lên vẻ đẹp và khẳng định phong cách <br>
của riêng mình, nàng nhé.',
(SELECT category_id FROM Categories WHERE category_name = N'Quà tặng'), 4.9, N'Nữ', 8491000.00, 480),


--THUONG HIEU
(N'Mặt dây chuyền Vàng Ý 10K DAL ❤️ HELLO KITTY 0000Y001639', N'Thương hiệu : SANRIO', (SELECT category_id FROM Categories WHERE category_name = N'Thương hiệu'), 5.0, N'Nữ', 1369000.00, 100),

(N'Mặt dây chuyền Vàng Ý 10K DAL ❤️ HELLO KITTY 0000Y001637', N'Thương hiệu : SANRIO', (SELECT category_id FROM Categories WHERE category_name = N'Thương hiệu'), 4.9, N'Unsex', 2140000.00, 120),

(N'Thẻ May mắn Vàng 10K DAL ❤️ HELLO KITTY Như Ý 0000Y000962', N'Thương hiệu : SANRIO', (SELECT category_id FROM Categories WHERE category_name = N'Thương hiệu'), 4.6, N'Unsex', 4868000.00, 120),

(N'Bông tai trẻ em Bạc DAL ❤️ HELLO KITTY 0000W000123', N'Thương hiệu : SANRIO', (SELECT category_id FROM Categories WHERE category_name = N'Thương hiệu'), 4.5, N'Unsex', 595000.00, 120),

(N'Bông tai Vàng trắng Ý 10K DAL ❤️ HELLO KITTY 0000W002716', N'Thương hiệu : SANRIO', (SELECT category_id FROM Categories WHERE category_name = N'Thương hiệu'), 4.4, N'Unsex', 3525000.00, 120),

(N'Bông tai Bạc đính đá DAL ❤️ HELLO KITTY ZT00H000005', N'Cùng DAL ❤️ HELLO KITTY làm mới phong cách với đôi bông tai bạc tinh tế này 
nhé nàng ơi! Bởi sự tinh tế trong nó chính là điểm nhấn đặc
biệt giúp nàng trở nên nổi bần bật và lan tỏa sức hút từ thần thái của mình.', (SELECT category_id FROM Categories WHERE category_name = N'Thương hiệu'), 4.9, N'Nữ', 3525000.00, 120),

(N'Bông tai Bạc đính đá DAL ❤️ HELLO KITTY XMXMW000085', N'Cùng DAL ❤️ HELLO KITTY làm mới phong cách với đôi bông tai bạc tinh tế này 
nhé nàng ơi! Bởi sự tinh tế trong nó chính là điểm nhấn đặc
biệt giúp nàng trở nên nổi bần bật và lan tỏa sức hút từ thần thái của mình.', (SELECT category_id FROM Categories WHERE category_name = N'Thương hiệu'), 4.8, N'Nữ', 655000.00, 120),

(N'Lắc tay trẻ em Bạc DAL ❤️ HELLO KITTY 0000W000103', N'Thương hiệu : SANRIO',
(SELECT category_id FROM Categories WHERE category_name = N'Thương hiệu'), 4.9, N'Nữ', 900000.00, 120),
--t 
(N'Hạt charm Bạc đính đá DAL ❤️ HELLO KITTY XMXMW000039', N'Thương hiệu : SANRIO',
(SELECT category_id FROM Categories WHERE category_name = N'Thương hiệu'), 4.9, N'Nữ', 580000.00, 120),

(N'Bông tai Bạc đính đá DAL ❤️ HELLO KITTY XMXMW000084', N'Thương hiệu : SANRIO',
(SELECT category_id FROM Categories WHERE category_name = N'Thương hiệu'), 4.0, N'Nữ', 650000.00, 120),

(N'Hạt Charm Bạc đính đá DALSilver hình chiếc thuyền ZTZTW060029', N'Thương hiệu : DALSilver',
(SELECT category_id FROM Categories WHERE category_name = N'Thương hiệu'), 4.9, N'Nữ', 550000.00, 220),

(N'Hạt Charm Bạc đính đá DALSilver XMXMW060430', N'Thương hiệu : DALSilver',
(SELECT category_id FROM Categories WHERE category_name = N'Thương hiệu'), 4.9, N'Nữ', 750000.00, 240),

(N'Hạt Charm Bạc đính đá DALSilver hình gấu hồng ZTXMW060008', N'Thương hiệu : DALSilver',
(SELECT category_id FROM Categories WHERE category_name = N'Thương hiệu'), 4.8, N'Nữ', 850000.00, 340),

(N'Mặt dây chuyền Vàng 14K đính đá CZ DAL ❤️ HELLO KITTY XMXMY063473', N'Thương hiệu : SANRIO',
(SELECT category_id FROM Categories WHERE category_name = N'Thương hiệu'), 4.9, N'Nữ', 4900000.00, 420),

(N'Bông tai Vàng 10K đính Ngọc trai Freshwater DAL ❤️ HELLO KITTY PF00Y000156', N'Thương hiệu : SANRIO',
(SELECT category_id FROM Categories WHERE category_name = N'Thương hiệu'), 4.9, N'Nữ', 900000.00, 220),

(N'Bông tai Vàng 10K đính Ngọc trai Freshwater DAL ❤️ HELLO KITTY PFXMY000642', N'Thương hiệu : SANRIO',
(SELECT category_id FROM Categories WHERE category_name = N'Thương hiệu'), 4.8, N'Nữ', 4900000.00, 320),

(N'Mặt dây chuyền Vàng trắng 14K Disney|DAL Minnie alone 0000W001137', N'Thương hiệu : Disney|DAL',
(SELECT category_id FROM Categories WHERE category_name = N'Thương hiệu'), 4.9, N'Nữ', 2900000.00, 120),

(N'Mặt dây chuyền Vàng 18K DAL Kim Bảo Như Ý 0000Y001485', N'Thương hiệu : DAL',
(SELECT category_id FROM Categories WHERE category_name = N'Thương hiệu'), 4.8, N'Nữ', 8900000.00, 420),

(N'Mặt dây chuyền Kim cương Vàng trắng 14K DAL DDDDW000957', N'Thương hiệu : DAL',
(SELECT category_id FROM Categories WHERE category_name = N'Thương hiệu'), 4.8, N'Nữ', 9900000.00, 220),

(N'Mặt dây chuyền Kim cương Vàng trắng 14K DAL DDDDW002605', N'Thương hiệu : DAL',
(SELECT category_id FROM Categories WHERE category_name = N'Thương hiệu'), 4.8, N'Nữ', 7900000.00, 520);


--psize4
INSERT INTO ProductSize (product_id, size, stock_quantity)
VALUES 
((SELECT product_id FROM Products WHERE title = N'Nhẫn cưới nam Kim cương Vàng 18K DAL DD00Y003449'), 9, 20);

INSERT INTO ProductSize (product_id, size, stock_quantity)
VALUES 
((SELECT product_id FROM Products WHERE title = N'Nhẫn cưới nam Kim cương Vàng 18K DAL DD00Y003449'), 10, 30);

INSERT INTO ProductSize (product_id, size, stock_quantity)
VALUES 
((SELECT product_id FROM Products WHERE title = N'Nhẫn cưới nam Kim cương Vàng 18K DAL DD00Y003449'), 11, 50);

INSERT INTO ProductSize (product_id, size, stock_quantity)
VALUES 
((SELECT product_id FROM Products WHERE title = N'Cặp nhẫn cưới Vàng trắng 14K DAL Trầu cau 02804-11767'), 9, 30);

INSERT INTO ProductSize (product_id, size, stock_quantity)
VALUES 
((SELECT product_id FROM Products WHERE title = N'Cặp nhẫn cưới Vàng trắng 14K DAL Trầu cau 02804-11767'), 10, 30);

INSERT INTO ProductSize (product_id, size, stock_quantity)
VALUES 
((SELECT product_id FROM Products WHERE title = N'Cặp nhẫn cưới Vàng trắng 14K DAL Trầu cau 02804-11767'), 11, 30);

INSERT INTO ProductSize (product_id, size, stock_quantity)
VALUES 
((SELECT product_id FROM Products WHERE title = N'Dây cổ cưới Vàng 24K DAL 0000Y000423'), 29, 30);

INSERT INTO ProductSize (product_id, size, stock_quantity)
VALUES 
((SELECT product_id FROM Products WHERE title = N'Dây cổ cưới Vàng 24K DAL 0000Y000423'), 30, 30);

INSERT INTO ProductSize (product_id, size, stock_quantity)
VALUES 
((SELECT product_id FROM Products WHERE title = N'Dây cổ cưới Vàng 24K DAL 0000Y000423'), 31, 30);

INSERT INTO ProductSize (product_id, size, stock_quantity)
VALUES 
((SELECT product_id FROM Products WHERE title = N'Bông tai Kim cương Vàng Trắng 14K DAL Trầu Cau DDDDW004320'), 0, 130);

INSERT INTO ProductSize (product_id, size, stock_quantity)
VALUES 
((SELECT product_id FROM Products WHERE title = N'Nhẫn cưới Kim cương Vàng Trắng 14K DAL DDDDW009976'), 8, 30);

INSERT INTO ProductSize (product_id, size, stock_quantity)
VALUES 
((SELECT product_id FROM Products WHERE title = N'Nhẫn cưới Kim cương Vàng Trắng 14K DAL DDDDW009976'), 13, 30);

INSERT INTO ProductSize (product_id, size, stock_quantity)
VALUES 
((SELECT product_id FROM Products WHERE title = N'Nhẫn cưới Kim cương Vàng Trắng 14K DAL DDDDW011925'), 13, 30);

INSERT INTO ProductSize (product_id, size, stock_quantity)
VALUES 
((SELECT product_id FROM Products WHERE title = N'Nhẫn cưới Kim cương Vàng Trắng 14K DAL Trầu Cau DDDDW011762'),13, 30);

INSERT INTO ProductSize (product_id, size, stock_quantity)
VALUES 
((SELECT product_id FROM Products WHERE title = N'Nhẫn Kim cương Vàng 18K DAL DDDDY000790'), 11, 30);

INSERT INTO ProductSize (product_id, size, stock_quantity)
VALUES 
((SELECT product_id FROM Products WHERE title = N'Nhẫn Kim cương Vàng 18K DAL DDDDY000790'), 12, 100);

INSERT INTO ProductSize (product_id, size, stock_quantity)
VALUES 
((SELECT product_id FROM Products WHERE title = N'Nhẫn Kim cương Vàng 18K DAL DDDDY000790'), 13, 300);

INSERT INTO ProductSize (product_id, size, stock_quantity)
VALUES 
((SELECT product_id FROM Products WHERE title = N'Nhẫn cưới nam Kim cương Vàng Trắng 14K DAL DD00W004085'), 17, 1000);

INSERT INTO ProductSize (product_id, size, stock_quantity)
VALUES 
((SELECT product_id FROM Products WHERE title = N'Nhẫn cưới nam Kim cương Vàng Trắng 14K DAL DD00W004085'), 18, 100);

INSERT INTO ProductSize (product_id, size, stock_quantity)
VALUES 
((SELECT product_id FROM Products WHERE title = N'Nhẫn cưới nam Kim cương Vàng Trắng 14K DAL DD00W004085'), 19, 100);

INSERT INTO ProductSize (product_id, size, stock_quantity)
VALUES 
((SELECT product_id FROM Products WHERE title = N'Nhẫn cưới Kim cương Vàng 18K DAL DD00Y000326'), 10, 100);

INSERT INTO ProductSize (product_id, size, stock_quantity)
VALUES 
((SELECT product_id FROM Products WHERE title = N'Nhẫn cưới Kim cương Vàng 18K DAL DD00Y000326'), 11, 100);

INSERT INTO ProductSize (product_id, size, stock_quantity)
VALUES 
((SELECT product_id FROM Products WHERE title = N'Nhẫn cưới Kim cương Vàng 18K DAL DD00Y000326'), 12, 100);

INSERT INTO ProductSize (product_id, size, stock_quantity)
VALUES 
((SELECT product_id FROM Products WHERE title = N'Nhẫn cưới Vàng 24K DAL Trầu Cau 0000Y003194'), 11, 100);

INSERT INTO ProductSize (product_id, size, stock_quantity)
VALUES 
((SELECT product_id FROM Products WHERE title = N'Nhẫn cưới Vàng 24K DAL Trầu Cau 0000Y003194'), 12, 100);

INSERT INTO ProductSize (product_id, size, stock_quantity)
VALUES 
((SELECT product_id FROM Products WHERE title = N'Nhẫn cưới Vàng 24K DAL Trầu Cau 0000Y003194'), 13, 100);

INSERT INTO ProductSize (product_id, size, stock_quantity)
SELECT p.product_id, 0, 100
FROM Products p
WHERE p.title IN (
    N'Bông tai Kim cương Vàng trắng 14K DAL DDDDW000182',
    N'Bông tai cưới Vàng 24K DAL 0000Y000113',
    N'Bông tai cưới Vàng 24K DAL Lan Mùa Hạ 0000Y000071',
    N'Bông tai cưới Vàng 24K DAL Duyên Phượng Tình Hồng 0000Y000102',
    N'Bông tai cưới Vàng 24K DAL 0000Y003038',
    N'Bông tai cưới Vàng 24K DAL Hạnh Phúc 0000Y000083',
    N'Bông tai cưới Vàng 18K đính đá ECZ DAL Trầu Cau XMXMY006013',
    N'Bông tai cưới Vàng 24K DAL Trầu cau 0000Y002680',
    N'Bông tai cưới Vàng trắng 10K đính đá ECZ DAL Bạch Khổng Tước XMXMW001971',

    N'Đồng hồ Disney & Marvel Nam M-6069R Dây Cao Su 50 mm',
    N'Đồng hồ Disney & Marvel Nam M-6072B Dây Cao Su 50 mm',
    N'Đồng Hồ Michael Kors Nữ MK7197 Dây Thép Không Gỉ 33 mm',
    N'Đồng Hồ Citizen Nữ EM0860-51D Dây Thép Không Gỉ 25 mm',
    N'Đồng Hồ Citizen Nam NH8390-71L Dây Thép Không Gỉ 40 mm',
    N'Đồng Hồ Fossil Nam ME3061 Dây Da 44mm',
    N'Đồng Hồ Citizen Nữ EM0502-86P Dây Thép Không Gỉ 32mm',
    N'Đồng Hồ Michael Kors Nữ MK3640 Dây Thép Không Gỉ 36mm',
    N'Đồng Hồ Fossil Nữ ES5192 Dây Thép Không Gỉ 37 mm',
    N'Đồng Hồ Nam Citizen NJ0150-81X Dây Thép Không Gỉ 40 mm',
    N'Đồng hồ Rado True Square Unisex R27073712 Dây Ceramic 38 mm',
    N'Đồng hồ Tissot Nam PRX T137.410.17.051.00 Dây Cao Su 40 mm',
    N'Đồng hồ Tissot Nam PRX Powermatic 80 T137.407.11.351.00 Dây Kim Loại 40 mm',
    N'Đồng hồ Longines La Grande Nữ L4.209.4.81.6 Dây Kim Loại 24 mm',
    N'Đồng hồ Longines Master Nam L2.919.4.92.6 Dây Kim Loại 42 mm',
    N'Đồng hồ Longines Master Nam L2.893.4.77.3 Dây Da 42 mm',
    N'Đồng hồ Calvin Klein Nam 25200293 Dây Kim Loại 44 mm',
    N'Đồng hồ Calvin Klein Nam 25200303 Dây Kim Loại 44.3 mm',
    N'Đồng hồ Rado Centrix Nữ R30029902 Dây Kim Loại 35 mm',
    N'Đồng hồ Rado Centrix Nữ R30248902 Dây Kim Loại 33 mm',
    N'Đồng hồ Rado Centrix Nữ R30037742 Dây Kim Loại 35 mm',

    N'Lắc tay Vàng 14K đính đá CZ Disney|DAL Mickey XMXMY061792',
    N'Bông tai Bạc đính ngọc trai DALSilver PF00W000024',
    N'Bông tai Vàng trắng 10K đính đá ECZ DAL XMXMW002314',
    N'Mặt dây chuyền Vàng Trắng 10K đính đá ECZ STYLE by DAL Sunlover XMXMW002476',
    N'Bông tai Vàng Trắng 10K đính đá ECZ STYLE by DAL Sunlover XM00W001263',
	N'Bông tai Vàng trắng 14K đính đá synthetic Disney|DAL Cinderella ZT00W000014',
	N'Bông tai trẻ em Bạc DALSilver 0000W060048',
	N'Bông tai trẻ em Bạc đính đá DALSilver XMXMW060171',
	N'Bông tai trẻ em Bạc DALSilver 0000W060046',
	N'Nhẫn trẻ em Bạc DALSilver 0000W060019',
	N'Bông tai Kim cương Vàng trắng 14K DAL DDDDW060268',
	N'Bông tai Kim cương Vàng trắng 14K DAL DDDDW060268',
	N'Bông tai Vàng 18K đính đá Ruby DAL Family Infinity RBXMC000008',
	N'Bông tai Vàng 10K STYLE by DAL 0000Y002594',
	N'Hạt charm xỏ trẻ em DIY DALSilver chữ sweet baby 0000H060002',
	N'Hạt charm xỏ trẻ em DIY DALSilver chữ baby xanh 00XMW060025',
	N'Mặt dây chuyền Kim cương Vàng trắng 14K DAL DDDDW000924',
	N'Mặt dây chuyền Vàng 14K đính đá CZ DAL ❤️ HELLO KITTY XM00C060002',
	N'Mặt dây chuyền Kim cương Vàng trắng 14K DAL DDDDW000923',
	N'Bông tai Kim Tiền Vàng trắng Ý 18K DAL 0000W002163',
	N'Mặt dây chuyền Vàng Ý 10K DAL ❤️ HELLO KITTY 0000Y001639',
	N'Mặt dây chuyền Vàng Ý 10K DAL ❤️ HELLO KITTY 0000Y001637',
	N'Thẻ May mắn Vàng 10K DAL ❤️ HELLO KITTY Như Ý 0000Y000962',
	N'Bông tai trẻ em Bạc DAL ❤️ HELLO KITTY 0000W000123',
	N'Bông tai Vàng trắng Ý 10K DAL ❤️ HELLO KITTY 0000W002716',
	N'Bông tai Bạc đính đá DAL ❤️ HELLO KITTY ZT00H000005',
	N'Bông tai Bạc đính đá DAL ❤️ HELLO KITTY XMXMW000085',
	N'Lắc tay trẻ em Bạc DAL ❤️ HELLO KITTY 0000W000103',
	N'Hạt charm Bạc đính đá DAL ❤️ HELLO KITTY XMXMW000039',
	N'Bông tai Bạc đính đá DAL ❤️ HELLO KITTY XMXMW000084',
	N'Hạt Charm Bạc đính đá DALSilver hình chiếc thuyền ZTZTW060029',
	N'Hạt Charm Bạc đính đá DALSilver XMXMW060430',
	N'Hạt Charm Bạc đính đá DALSilver hình gấu hồng ZTXMW060008',
	N'Mặt dây chuyền Vàng 14K đính đá CZ DAL ❤️ HELLO KITTY XMXMY063473',
	N'Bông tai Vàng 10K đính Ngọc trai Freshwater DAL ❤️ HELLO KITTY PF00Y000156',
	N'Bông tai Vàng 10K đính Ngọc trai Freshwater DAL ❤️ HELLO KITTY PFXMY000642',
	N'Mặt dây chuyền Vàng trắng 14K Disney|DAL Minnie alone 0000W001137',
	N'Mặt dây chuyền Vàng 18K DAL Kim Bảo Như Ý 0000Y001485',
	N'Mặt dây chuyền Kim cương Vàng trắng 14K DAL DDDDW000957'
    -- Thêm các sản phẩm khác tại đây
);



--primg5
INSERT INTO ProductImages (ProductID, ImageURL)
VALUES 
((SELECT TOP 1 product_id FROM Products WHERE title = N'Nhẫn cưới nam Kim cương Vàng 18K DAL DD00Y003449'), '/image/product/trangsuccuoi/sp-gndd00y003449-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Nhẫn cưới nam Kim cương Vàng 18K DAL DD00Y003449'), '/image/product/trangsuccuoi/sp-gndd00y003449-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Nhẫn cưới nam Kim cương Vàng 18K DAL DD00Y003449'), '/image/product/trangsuccuoi/sp-gndd00y003449-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Cặp nhẫn cưới Vàng trắng 14K DAL Trầu cau 02804-11767'), '/image/product/trangsuccuoi/sp-02804-11767-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Cặp nhẫn cưới Vàng trắng 14K DAL Trầu cau 02804-11767'), '/image/product/trangsuccuoi/sp-02804-11767-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Cặp nhẫn cưới Vàng trắng 14K DAL Trầu cau 02804-11767'), '/image/product/trangsuccuoi/sp-02804-11767-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Dây cổ cưới Vàng 24K DAL 0000Y000423'), '/image/product/trangsuccuoi/sp-gc0000y000423-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Dây cổ cưới Vàng 24K DAL 0000Y000423'), '/image/product/trangsuccuoi/sp-gc0000y000423-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Dây cổ cưới Vàng 24K DAL 0000Y000423'), '/image/product/trangsuccuoi/sp-gc0000y000423-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai Kim cương Vàng Trắng 14K DAL Trầu Cau DDDDW004320'), '/image/product/trangsuccuoi/sp-gbddddw004320-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai Kim cương Vàng Trắng 14K DAL Trầu Cau DDDDW004320'), '/image/product/trangsuccuoi/sp-gbddddw004320-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai Kim cương Vàng Trắng 14K DAL Trầu Cau DDDDW004320'), '/image/product/trangsuccuoi/sp-gbddddw004320-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Nhẫn cưới Kim cương Vàng Trắng 14K DAL DDDDW009976'), '/image/product/trangsuccuoi/sp-gnddddw009976-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Nhẫn cưới Kim cương Vàng Trắng 14K DAL DDDDW009976'), '/image/product/trangsuccuoi/sp-gnddddw009976-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Nhẫn cưới Kim cương Vàng Trắng 14K DAL DDDDW009976'), '/image/product/trangsuccuoi/sp-gnddddw009976-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Nhẫn cưới Kim cương Vàng Trắng 14K DAL DDDDW011925'), '/image/product/trangsuccuoi/sp-gnddddw011925-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Nhẫn cưới Kim cương Vàng Trắng 14K DAL DDDDW011925'), '/image/product/trangsuccuoi/sp-gnddddw011925-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Nhẫn cưới Kim cương Vàng Trắng 14K DAL DDDDW011925'), '/image/product/trangsuccuoi/sp-gnddddw011925-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Nhẫn cưới Kim cương Vàng Trắng 14K DAL Trầu Cau DDDDW011762'), '/image/product/trangsuccuoi/sp-gnddddw011762-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Nhẫn cưới Kim cương Vàng Trắng 14K DAL Trầu Cau DDDDW011762'), '/image/product/trangsuccuoi/sp-gnddddw011762-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Nhẫn cưới Kim cương Vàng Trắng 14K DAL Trầu Cau DDDDW011762'), '/image/product/trangsuccuoi/sp-gnddddw011762-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Nhẫn Kim cương Vàng 18K DAL DDDDY000790'), '/image/product/trangsuccuoi/sp-gnddddy000790-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Nhẫn Kim cương Vàng 18K DAL DDDDY000790'), '/image/product/trangsuccuoi/sp-gnddddy000790-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Nhẫn Kim cương Vàng 18K DAL DDDDY000790'), '/image/product/trangsuccuoi/sp-gnddddy000790-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Nhẫn cưới nam Kim cương Vàng Trắng 14K DAL DD00W004085'), '/image/product/trangsuccuoi/sp-gndd00w004085-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Nhẫn cưới nam Kim cương Vàng Trắng 14K DAL DD00W004085'), '/image/product/trangsuccuoi/sp-gndd00w004085-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Nhẫn cưới nam Kim cương Vàng Trắng 14K DAL DD00W004085'), '/image/product/trangsuccuoi/sp-gndd00w004085-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Nhẫn cưới Kim cương Vàng 18K DAL DD00Y000326'), '/image/product/trangsuccuoi/sp-gndd00y000326-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Nhẫn cưới Kim cương Vàng 18K DAL DD00Y000326'), '/image/product/trangsuccuoi/sp-gndd00y000326-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Nhẫn cưới Kim cương Vàng 18K DAL DD00Y000326'), '/image/product/trangsuccuoi/sp-gndd00y000326-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Nhẫn cưới Vàng 24K DAL Trầu Cau 0000Y003194'), '/image/product/trangsuccuoi/sp-gn0000y003194-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Nhẫn cưới Vàng 24K DAL Trầu Cau 0000Y003194'), '/image/product/trangsuccuoi/sp-gn0000y003194-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Nhẫn cưới Vàng 24K DAL Trầu Cau 0000Y003194'), '/image/product/trangsuccuoi/sp-gn0000y003194-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai Kim cương Vàng trắng 14K DAL DDDDW000182'), '/image/product/trangsuccuoi/sp-gbddddw000182-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai Kim cương Vàng trắng 14K DAL DDDDW000182'), '/image/product/trangsuccuoi/sp-gbddddw000182-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai Kim cương Vàng trắng 14K DAL DDDDW000182'), '/image/product/trangsuccuoi/sp-gbddddw000182-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai cưới Vàng 24K DAL 0000Y000113'), '/image/product/trangsuccuoi/gb0000y000113-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai cưới Vàng 24K DAL 0000Y000113'), '/image/product/trangsuccuoi/gb0000y000113-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai cưới Vàng 24K DAL 0000Y000113'), '/image/product/trangsuccuoi/gb0000y000113-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai cưới Vàng 24K DAL Lan Mùa Hạ 0000Y000071'), '/image/product/trangsuccuoi/sp-gb0000y000071-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai cưới Vàng 24K DAL Lan Mùa Hạ 0000Y000071'), '/image/product/trangsuccuoi/sp-gb0000y000071-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai cưới Vàng 24K DAL Lan Mùa Hạ 0000Y000071'), '/image/product/trangsuccuoi/sp-gb0000y000071-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai cưới Vàng 24K DAL Duyên Phượng Tình Hồng 0000Y000102'), '/image/product/trangsuccuoi/sp-gb0000y000102-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai cưới Vàng 24K DAL Duyên Phượng Tình Hồng 0000Y000102'), '/image/product/trangsuccuoi/sp-gb0000y000102-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai cưới Vàng 24K DAL Duyên Phượng Tình Hồng 0000Y000102'), '/image/product/trangsuccuoi/sp-gb0000y000102-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai cưới Vàng 24K DAL 0000Y003038'), '/image/product/trangsuccuoi/sp-gb0000y003038-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai cưới Vàng 24K DAL 0000Y003038'), '/image/product/trangsuccuoi/sp-gb0000y003038-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai cưới Vàng 24K DAL 0000Y003038'), '/image/product/trangsuccuoi/sp-gb0000y003038-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai cưới Vàng 24K DAL Hạnh Phúc 0000Y000083'), '/image/product/trangsuccuoi/sp-gb0000y000083-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai cưới Vàng 24K DAL Hạnh Phúc 0000Y000083'), '/image/product/trangsuccuoi/sp-gb0000y000083-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai cưới Vàng 24K DAL Hạnh Phúc 0000Y000083'), '/image/product/trangsuccuoi/sp-gb0000y000083-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai cưới Vàng 18K đính đá ECZ DAL Trầu Cau XMXMY006013'), '/image/product/trangsuccuoi/sp-GBXMXMY006013-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai cưới Vàng 18K đính đá ECZ DAL Trầu Cau XMXMY006013'), '/image/product/trangsuccuoi/sp-GBXMXMY006013-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai cưới Vàng 18K đính đá ECZ DAL Trầu Cau XMXMY006013'), '/image/product/trangsuccuoi/sp-GBXMXMY006013-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai cưới Vàng 24K DAL Trầu cau 0000Y002680'), '/image/product/trangsuccuoi/sp-GB0000Y002680-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai cưới Vàng 24K DAL Trầu cau 0000Y002680'), '/image/product/trangsuccuoi/sp-GB0000Y002680-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai cưới Vàng 24K DAL Trầu cau 0000Y002680'), '/image/product/trangsuccuoi/sp-GB0000Y002680-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai cưới Vàng trắng 10K đính đá ECZ DAL Bạch Khổng Tước XMXMW001971'), '/image/product/trangsuccuoi/gbxmxmw001971-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai cưới Vàng trắng 10K đính đá ECZ DAL Bạch Khổng Tước XMXMW001971'), '/image/product/trangsuccuoi/gbxmxmw001971-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai cưới Vàng trắng 10K đính đá ECZ DAL Bạch Khổng Tước XMXMW001971'), '/image/product/trangsuccuoi/gbxmxmw001971-3.png'),





((SELECT TOP 1 product_id FROM Products WHERE title = N'Đồng hồ Disney & Marvel Nam M-6069R Dây Cao Su 50 mm'), '/image/product/dongho/sp-6069r-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Đồng hồ Disney & Marvel Nam M-6069R Dây Cao Su 50 mm'), '/image/product/dongho/sp-6069r-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Đồng hồ Disney & Marvel Nam M-6069R Dây Cao Su 50 mm'), '/image/product/dongho/sp-6069r-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Đồng hồ Disney & Marvel Nam M-6072B Dây Cao Su 50 mm'), '/image/product/dongho/sp-6072b-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Đồng hồ Disney & Marvel Nam M-6072B Dây Cao Su 50 mm'), '/image/product/dongho/sp-6072b-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Đồng hồ Disney & Marvel Nam M-6072B Dây Cao Su 50 mm'), '/image/product/dongho/sp-6072b-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Đồng Hồ Michael Kors Nữ MK7197 Dây Thép Không Gỉ 33 mm'), '/image/product/dongho/sp-mk7197-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Đồng Hồ Michael Kors Nữ MK7197 Dây Thép Không Gỉ 33 mm'), '/image/product/dongho/sp-mk7197-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Đồng Hồ Michael Kors Nữ MK7197 Dây Thép Không Gỉ 33 mm'), '/image/product/dongho/sp-mk7197-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Đồng Hồ Citizen Nữ EM0860-51D Dây Thép Không Gỉ 25 mm'), '/image/product/dongho/sp-em0860-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Đồng Hồ Citizen Nữ EM0860-51D Dây Thép Không Gỉ 25 mm'), '/image/product/dongho/sp-em0860-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Đồng Hồ Citizen Nữ EM0860-51D Dây Thép Không Gỉ 25 mm'), '/image/product/dongho/sp-em0860-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Đồng Hồ Citizen Nam NH8390-71L Dây Thép Không Gỉ 40 mm'), '/image/product/dongho/sp-nh8390-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Đồng Hồ Citizen Nam NH8390-71L Dây Thép Không Gỉ 40 mm'), '/image/product/dongho/sp-nh8390-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Đồng Hồ Citizen Nam NH8390-71L Dây Thép Không Gỉ 40 mm'), '/image/product/dongho/sp-nh8390-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Đồng Hồ Fossil Nam ME3061 Dây Da 44mm'), '/image/product/dongho/sp-me3061-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Đồng Hồ Fossil Nam ME3061 Dây Da 44mm'), '/image/product/dongho/sp-me3061-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Đồng Hồ Fossil Nam ME3061 Dây Da 44mm'), '/image/product/dongho/sp-me3061-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Đồng Hồ Citizen Nữ EM0502-86P Dây Thép Không Gỉ 32mm'), '/image/product/dongho/sp-em0502-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Đồng Hồ Citizen Nữ EM0502-86P Dây Thép Không Gỉ 32mm'), '/image/product/dongho/sp-em0502-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Đồng Hồ Citizen Nữ EM0502-86P Dây Thép Không Gỉ 32mm'), '/image/product/dongho/sp-em0502-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Đồng Hồ Michael Kors Nữ MK3640 Dây Thép Không Gỉ 36mm'), '/image/product/dongho/sp-mk3640-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Đồng Hồ Michael Kors Nữ MK3640 Dây Thép Không Gỉ 36mm'), '/image/product/dongho/sp-mk3640-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Đồng Hồ Michael Kors Nữ MK3640 Dây Thép Không Gỉ 36mm'), '/image/product/dongho/sp-mk3640-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Đồng Hồ Fossil Nữ ES5192 Dây Thép Không Gỉ 37 mm'), '/image/product/dongho/sp-es5192-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Đồng Hồ Fossil Nữ ES5192 Dây Thép Không Gỉ 37 mm'), '/image/product/dongho/sp-es5192-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Đồng Hồ Fossil Nữ ES5192 Dây Thép Không Gỉ 37 mm'), '/image/product/dongho/sp-es5192-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Đồng Hồ Nam Citizen NJ0150-81X Dây Thép Không Gỉ 40 mm'), '/image/product/dongho/sp-81x-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Đồng Hồ Nam Citizen NJ0150-81X Dây Thép Không Gỉ 40 mm'), '/image/product/dongho/sp-81x-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Đồng Hồ Nam Citizen NJ0150-81X Dây Thép Không Gỉ 40 mm'), '/image/product/dongho/sp-81x-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Đồng hồ Rado True Square Unisex R27073712 Dây Ceramic 38 mm'), '/image/product/dongho/sp-wuraawddc38.0208-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Đồng hồ Rado True Square Unisex R27073712 Dây Ceramic 38 mm'), '/image/product/dongho/sp-wuraawddc38.0208-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Đồng hồ Rado True Square Unisex R27073712 Dây Ceramic 38 mm'), '/image/product/dongho/sp-wuraawddc38.0208-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Đồng hồ Tissot Nam PRX T137.410.17.051.00 Dây Cao Su 40 mm'), '/image/product/dongho/sp-wti00000714-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Đồng hồ Tissot Nam PRX T137.410.17.051.00 Dây Cao Su 40 mm'), '/image/product/dongho/sp-wti00000714-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Đồng hồ Tissot Nam PRX T137.410.17.051.00 Dây Cao Su 40 mm'), '/image/product/dongho/sp-wti00000714-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Đồng hồ Tissot Nam PRX Powermatic 80 T137.407.11.351.00 Dây Kim Loại 40 mm'), '/image/product/dongho/sp-wti00000712-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Đồng hồ Tissot Nam PRX Powermatic 80 T137.407.11.351.00 Dây Kim Loại 40 mm'), '/image/product/dongho/sp-wti00000712-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Đồng hồ Tissot Nam PRX Powermatic 80 T137.407.11.351.00 Dây Kim Loại 40 mm'), '/image/product/dongho/sp-wti00000712-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Đồng hồ Longines La Grande Nữ L4.209.4.81.6 Dây Kim Loại 24 mm'), '/image/product/dongho/sp-wlo00000757-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Đồng hồ Longines La Grande Nữ L4.209.4.81.6 Dây Kim Loại 24 mm'), '/image/product/dongho/sp-wlo00000757-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Đồng hồ Longines La Grande Nữ L4.209.4.81.6 Dây Kim Loại 24 mm'), '/image/product/dongho/sp-wlo00000757-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Đồng hồ Longines Master Nam L2.919.4.92.6 Dây Kim Loại 42 mm'), '/image/product/dongho/sp-wlo00000754-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Đồng hồ Longines Master Nam L2.919.4.92.6 Dây Kim Loại 42 mm'), '/image/product/dongho/sp-wlo00000754-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Đồng hồ Longines Master Nam L2.919.4.92.6 Dây Kim Loại 42 mm'), '/image/product/dongho/sp-wlo00000754-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Đồng hồ Longines Master Nam L2.893.4.77.3 Dây Da 42 mm'), '/image/product/dongho/sp-wmloawddl42.1165-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Đồng hồ Longines Master Nam L2.893.4.77.3 Dây Da 42 mm'), '/image/product/dongho/sp-wmloawddl42.1165-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Đồng hồ Longines Master Nam L2.893.4.77.3 Dây Da 42 mm'), '/image/product/dongho/sp-wmloawddl42.1165-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Đồng hồ Calvin Klein Nam 25200293 Dây Kim Loại 44 mm'), '/image/product/dongho/sp-wck00000433-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Đồng hồ Calvin Klein Nam 25200293 Dây Kim Loại 44 mm'), '/image/product/dongho/sp-wck00000433-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Đồng hồ Calvin Klein Nam 25200293 Dây Kim Loại 44 mm'), '/image/product/dongho/sp-wck00000433-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Đồng hồ Calvin Klein Nam 25200303 Dây Kim Loại 44.3 mm'), '/image/product/dongho/sp-wck00000428-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Đồng hồ Calvin Klein Nam 25200303 Dây Kim Loại 44.3 mm'), '/image/product/dongho/sp-wck00000428-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Đồng hồ Calvin Klein Nam 25200303 Dây Kim Loại 44.3 mm'), '/image/product/dongho/sp-wck00000428-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Đồng hồ Rado Centrix Nữ R30029902 Dây Kim Loại 35 mm'), '/image/product/dongho/sp-wfraawdds35.0206-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Đồng hồ Rado Centrix Nữ R30029902 Dây Kim Loại 35 mm'), '/image/product/dongho/sp-wfraawdds35.0206-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Đồng hồ Rado Centrix Nữ R30029902 Dây Kim Loại 35 mm'), '/image/product/dongho/sp-wfraawdds35.0206-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Đồng hồ Rado Centrix Nữ R30248902 Dây Kim Loại 33 mm'), '/image/product/dongho/sp-wfraawdds33.0154-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Đồng hồ Rado Centrix Nữ R30248902 Dây Kim Loại 33 mm'), '/image/product/dongho/sp-wfraawdds33.0154-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Đồng hồ Rado Centrix Nữ R30248902 Dây Kim Loại 33 mm'), '/image/product/dongho/sp-wfraawdds33.0154-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Đồng hồ Rado Centrix Nữ R30037742 Dây Kim Loại 35 mm'), '/image/product/dongho/sp-wfraawdds35.0150-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Đồng hồ Rado Centrix Nữ R30037742 Dây Kim Loại 35 mm'), '/image/product/dongho/sp-wfraawdds35.0150-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Đồng hồ Rado Centrix Nữ R30037742 Dây Kim Loại 35 mm'), '/image/product/dongho/sp-wfraawdds35.0150-3.png'),




((SELECT TOP 1 product_id FROM Products WHERE title = N'Lắc tay Vàng 14K đính đá CZ Disney|DAL Mickey XMXMY061792'), '/image/product/quatang/sp-glxmxmy061792-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Lắc tay Vàng 14K đính đá CZ Disney|DAL Mickey XMXMY061792'), '/image/product/quatang/sp-glxmxmy061792-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Lắc tay Vàng 14K đính đá CZ Disney|DAL Mickey XMXMY061792'), '/image/product/quatang/sp-glxmxmy061792-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai Bạc đính ngọc trai DALSilver PF00W000024'), '/image/product/quatang/sp-sbpf00w000024-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai Bạc đính ngọc trai DALSilver PF00W000024'), '/image/product/quatang/sp-sbpf00w000024-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai Bạc đính ngọc trai DALSilver PF00W000024'), '/image/product/quatang/sp-sbpf00w000024-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai Vàng trắng 10K đính đá ECZ DAL XMXMW002314'), '/image/product/quatang/sp-gbxmxmw002314-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai Vàng trắng 10K đính đá ECZ DAL XMXMW002314'), '/image/product/quatang/sp-gbxmxmw002314-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai Vàng trắng 10K đính đá ECZ DAL XMXMW002314'), '/image/product/quatang/sp-gbxmxmw002314-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Mặt dây chuyền Vàng Trắng 10K đính đá ECZ STYLE by DAL Sunlover XMXMW002476'), '/image/product/quatang/sp-gmxmxmw002476-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Mặt dây chuyền Vàng Trắng 10K đính đá ECZ STYLE by DAL Sunlover XMXMW002476'), '/image/product/quatang/sp-gmxmxmw002476-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Mặt dây chuyền Vàng Trắng 10K đính đá ECZ STYLE by DAL Sunlover XMXMW002476'), '/image/product/quatang/sp-gmxmxmw002476-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai Vàng Trắng 10K đính đá ECZ STYLE by DAL Sunlover XM00W001263'), '/image/product/quatang/sp-gbxm00w001263-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai Vàng Trắng 10K đính đá ECZ STYLE by DAL Sunlover XM00W001263'), '/image/product/quatang/sp-gbxm00w001263-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai Vàng Trắng 10K đính đá ECZ STYLE by DAL Sunlover XM00W001263'), '/image/product/quatang/sp-gbxm00w001263-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai Vàng trắng 14K đính đá synthetic Disney|DAL Cinderella ZT00W000014'), '/image/product/quatang/sp-gbzt00w000014-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai Vàng trắng 14K đính đá synthetic Disney|DAL Cinderella ZT00W000014'), '/image/product/quatang/sp-gbzt00w000014-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai Vàng trắng 14K đính đá synthetic Disney|DAL Cinderella ZT00W000014'), '/image/product/quatang/sp-gbzt00w000014-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai trẻ em Bạc DALSilver 0000W060048'), '/image/product/quatang/sb0000w060048-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai trẻ em Bạc DALSilver 0000W060048'), '/image/product/quatang/sb0000w060048-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai trẻ em Bạc DALSilver 0000W060048'), '/image/product/quatang/sb0000w060048-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai trẻ em Bạc đính đá DALSilver XMXMW060171'), '/image/product/quatang/sbxmxmw060171-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai trẻ em Bạc đính đá DALSilver XMXMW060171'), '/image/product/quatang/sbxmxmw060171-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai trẻ em Bạc đính đá DALSilver XMXMW060171'), '/image/product/quatang/sbxmxmw060171-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai trẻ em Bạc DALSilver 0000W060046'), '/image/product/quatang/sb0000w060046-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai trẻ em Bạc DALSilver 0000W060046'), '/image/product/quatang/sb0000w060046-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai trẻ em Bạc DALSilver 0000W060046'), '/image/product/quatang/sb0000w060046-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Nhẫn trẻ em Bạc DALSilver 0000W060019'), '/image/product/quatang/sn0000w060019-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Nhẫn trẻ em Bạc DALSilver 0000W060019'), '/image/product/quatang/sn0000w060019-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Nhẫn trẻ em Bạc DALSilver 0000W060019'), '/image/product/quatang/sn0000w060019-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai Kim cương Vàng trắng 14K DAL DDDDW060268'), '/image/product/quatang/gbddddw060268-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai Kim cương Vàng trắng 14K DAL DDDDW060268'), '/image/product/quatang/gbddddw060268-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai Kim cương Vàng trắng 14K DAL DDDDW060268'), '/image/product/quatang/gbddddw060268-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai Vàng 18K đính đá Ruby DAL Family Infinity RBXMC000008'), '/image/product/quatang/sp-gbrbxmc000008-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai Vàng 18K đính đá Ruby DAL Family Infinity RBXMC000008'), '/image/product/quatang/sp-gbrbxmc000008-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai Vàng 18K đính đá Ruby DAL Family Infinity RBXMC000008'), '/image/product/quatang/sp-gbrbxmc000008-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai Vàng 10K STYLE by DAL 0000Y002594'), '/image/product/quatang/gb0000y002594-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai Vàng 10K STYLE by DAL 0000Y002594'), '/image/product/quatang/gb0000y002594-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai Vàng 10K STYLE by DAL 0000Y002594'), '/image/product/quatang/gb0000y002594-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Hạt charm xỏ trẻ em DIY DALSilver chữ sweet baby 0000H060002'), '/image/product/quatang/sp-si0000h060002-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Hạt charm xỏ trẻ em DIY DALSilver chữ sweet baby 0000H060002'), '/image/product/quatang/sp-si0000h060002-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Hạt charm xỏ trẻ em DIY DALSilver chữ sweet baby 0000H060002'), '/image/product/quatang/sp-si0000h060002-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Hạt charm xỏ trẻ em DIY DALSilver chữ baby xanh 00XMW060025'), '/image/product/quatang/si00xmw060025-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Hạt charm xỏ trẻ em DIY DALSilver chữ baby xanh 00XMW060025'), '/image/product/quatang/si00xmw060025-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Hạt charm xỏ trẻ em DIY DALSilver chữ baby xanh 00XMW060025'), '/image/product/quatang/si00xmw060025-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Mặt dây chuyền Kim cương Vàng trắng 14K DAL DDDDW000924'), '/image/product/quatang/sp-gmddddw000924-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Mặt dây chuyền Kim cương Vàng trắng 14K DAL DDDDW000924'), '/image/product/quatang/sp-gmddddw000924-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Mặt dây chuyền Kim cương Vàng trắng 14K DAL DDDDW000924'), '/image/product/quatang/sp-gmddddw000924-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Mặt dây chuyền Vàng 14K đính đá CZ DAL ❤️ HELLO KITTY XM00C060002'), '/image/product/quatang/gmxm00c060002-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Mặt dây chuyền Vàng 14K đính đá CZ DAL ❤️ HELLO KITTY XM00C060002'), '/image/product/quatang/gmxm00c060002-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Mặt dây chuyền Vàng 14K đính đá CZ DAL ❤️ HELLO KITTY XM00C060002'), '/image/product/quatang/gmxm00c060002-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Mặt dây chuyền Kim cương Vàng trắng 14K DAL DDDDW000923'), '/image/product/quatang/sp-gmddddw000923-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Mặt dây chuyền Kim cương Vàng trắng 14K DAL DDDDW000923'), '/image/product/quatang/sp-gmddddw000923-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Mặt dây chuyền Kim cương Vàng trắng 14K DAL DDDDW000923'), '/image/product/quatang/sp-gmddddw000923-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai Kim Tiền Vàng trắng Ý 18K DAL 0000W002163'), '/image/product/quatang/gb0000w002163-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai Kim Tiền Vàng trắng Ý 18K DAL 0000W002163'), '/image/product/quatang/gb0000w002163-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai Kim Tiền Vàng trắng Ý 18K DAL 0000W002163'), '/image/product/quatang/gb0000w002163-3.png'),





((SELECT TOP 1 product_id FROM Products WHERE title = N'Mặt dây chuyền Vàng Ý 10K DAL ❤️ HELLO KITTY 0000Y001639'), '/image/product/thuonghieu/sp-gm0000y001639-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Mặt dây chuyền Vàng Ý 10K DAL ❤️ HELLO KITTY 0000Y001639'), '/image/product/thuonghieu/sp-gm0000y001639-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Mặt dây chuyền Vàng Ý 10K DAL ❤️ HELLO KITTY 0000Y001639'), '/image/product/thuonghieu/sp-gm0000y001639-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Mặt dây chuyền Vàng Ý 10K DAL ❤️ HELLO KITTY 0000Y001637'), '/image/product/thuonghieu/sp-gm0000y001637-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Mặt dây chuyền Vàng Ý 10K DAL ❤️ HELLO KITTY 0000Y001637'), '/image/product/thuonghieu/sp-gm0000y001637-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Mặt dây chuyền Vàng Ý 10K DAL ❤️ HELLO KITTY 0000Y001637'), '/image/product/thuonghieu/sp-gm0000y001637-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Thẻ May mắn Vàng 10K DAL ❤️ HELLO KITTY Như Ý 0000Y000962'), '/image/product/thuonghieu/sp-gz0000y000962-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Thẻ May mắn Vàng 10K DAL ❤️ HELLO KITTY Như Ý 0000Y000962'), '/image/product/thuonghieu/sp-gz0000y000962-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Thẻ May mắn Vàng 10K DAL ❤️ HELLO KITTY Như Ý 0000Y000962'), '/image/product/thuonghieu/sp-gz0000y000962-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai trẻ em Bạc DAL ❤️ HELLO KITTY 0000W000123'), '/image/product/thuonghieu/sp-sb0000w000123-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai trẻ em Bạc DAL ❤️ HELLO KITTY 0000W000123'), '/image/product/thuonghieu/sp-sb0000w000123-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai trẻ em Bạc DAL ❤️ HELLO KITTY 0000W000123'), '/image/product/thuonghieu/sp-sb0000w000123-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai Vàng trắng Ý 10K DAL ❤️ HELLO KITTY 0000W002716'), '/image/product/thuonghieu/sp-gb0000w002716-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai Vàng trắng Ý 10K DAL ❤️ HELLO KITTY 0000W002716'), '/image/product/thuonghieu/sp-gb0000w002716-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai Vàng trắng Ý 10K DAL ❤️ HELLO KITTY 0000W002716'), '/image/product/thuonghieu/sp-gb0000w002716-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai Bạc đính đá DAL ❤️ HELLO KITTY ZT00H000005'), '/image/product/thuonghieu/sp-sbzt00h000005-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai Bạc đính đá DAL ❤️ HELLO KITTY ZT00H000005'), '/image/product/thuonghieu/sp-sbzt00h000005-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai Bạc đính đá DAL ❤️ HELLO KITTY ZT00H000005'), '/image/product/thuonghieu/sp-sbzt00h000005-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai Bạc đính đá DAL ❤️ HELLO KITTY XMXMW000085'), '/image/product/thuonghieu/sp-sbxmxmw000085-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai Bạc đính đá DAL ❤️ HELLO KITTY XMXMW000085'), '/image/product/thuonghieu/sp-sbxmxmw000085-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai Bạc đính đá DAL ❤️ HELLO KITTY XMXMW000085'), '/image/product/thuonghieu/sp-sbxmxmw000085-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Lắc tay trẻ em Bạc DAL ❤️ HELLO KITTY 0000W000103'), '/image/product/thuonghieu/sp-sl0000w000103-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Lắc tay trẻ em Bạc DAL ❤️ HELLO KITTY 0000W000103'), '/image/product/thuonghieu/sp-sl0000w000103-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Lắc tay trẻ em Bạc DAL ❤️ HELLO KITTY 0000W000103'), '/image/product/thuonghieu/sp-sl0000w000103-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Hạt charm Bạc đính đá DAL ❤️ HELLO KITTY XMXMW000039'), '/image/product/thuonghieu/sp-sixmxmw000039-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Hạt charm Bạc đính đá DAL ❤️ HELLO KITTY XMXMW000039'), '/image/product/thuonghieu/sp-sixmxmw000039-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Hạt charm Bạc đính đá DAL ❤️ HELLO KITTY XMXMW000039'), '/image/product/thuonghieu/sp-sixmxmw000039-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai Bạc đính đá DAL ❤️ HELLO KITTY XMXMW000084'), '/image/product/thuonghieu/sp-sbxmxmw000084-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai Bạc đính đá DAL ❤️ HELLO KITTY XMXMW000084'), '/image/product/thuonghieu/sp-sbxmxmw000084-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai Bạc đính đá DAL ❤️ HELLO KITTY XMXMW000084'), '/image/product/thuonghieu/sp-sbxmxmw000084-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Hạt Charm Bạc đính đá DALSilver hình chiếc thuyền ZTZTW060029'), '/image/product/thuonghieu/sp-siztztw060029-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Hạt Charm Bạc đính đá DALSilver hình chiếc thuyền ZTZTW060029'), '/image/product/thuonghieu/sp-siztztw060029-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Hạt Charm Bạc đính đá DALSilver hình chiếc thuyền ZTZTW060029'), '/image/product/thuonghieu/sp-siztztw060029-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Hạt Charm Bạc đính đá DALSilver XMXMW060430'), '/image/product/thuonghieu/sp-sixmxmw060430-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Hạt Charm Bạc đính đá DALSilver XMXMW060430'), '/image/product/thuonghieu/sp-sixmxmw060430-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Hạt Charm Bạc đính đá DALSilver XMXMW060430'), '/image/product/thuonghieu/sp-sixmxmw060430-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Hạt Charm Bạc đính đá DALSilver hình gấu hồng ZTXMW060008'), '/image/product/thuonghieu/sp-siztxmw060008-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Hạt Charm Bạc đính đá DALSilver hình gấu hồng ZTXMW060008'), '/image/product/thuonghieu/sp-siztxmw060008-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Hạt Charm Bạc đính đá DALSilver hình gấu hồng ZTXMW060008'), '/image/product/thuonghieu/sp-siztxmw060008-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Mặt dây chuyền Vàng 14K đính đá CZ DAL ❤️ HELLO KITTY XMXMY063473'), '/image/product/thuonghieu/gmxmxmy063473-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Mặt dây chuyền Vàng 14K đính đá CZ DAL ❤️ HELLO KITTY XMXMY063473'), '/image/product/thuonghieu/gmxmxmy063473-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Mặt dây chuyền Vàng 14K đính đá CZ DAL ❤️ HELLO KITTY XMXMY063473'), '/image/product/thuonghieu/gmxmxmy063473-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai Vàng 10K đính Ngọc trai Freshwater DAL ❤️ HELLO KITTY PF00Y000156'), '/image/product/thuonghieu/sp-gbpf00y000156-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai Vàng 10K đính Ngọc trai Freshwater DAL ❤️ HELLO KITTY PF00Y000156'), '/image/product/thuonghieu/sp-gbpf00y000156-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai Vàng 10K đính Ngọc trai Freshwater DAL ❤️ HELLO KITTY PF00Y000156'), '/image/product/thuonghieu/sp-gbpf00y000156-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai Vàng 10K đính Ngọc trai Freshwater DAL ❤️ HELLO KITTY PFXMY000642'), '/image/product/thuonghieu/sp-gbpfxmy000642-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai Vàng 10K đính Ngọc trai Freshwater DAL ❤️ HELLO KITTY PFXMY000642'), '/image/product/thuonghieu/sp-gbpfxmy000642-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Bông tai Vàng 10K đính Ngọc trai Freshwater DAL ❤️ HELLO KITTY PFXMY000642'), '/image/product/thuonghieu/sp-gbpfxmy000642-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Mặt dây chuyền Vàng trắng 14K Disney|DAL Minnie alone 0000W001137'), '/image/product/thuonghieu/sp-gm0000w001137-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Mặt dây chuyền Vàng trắng 14K Disney|DAL Minnie alone 0000W001137'), '/image/product/thuonghieu/sp-gm0000w001137-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Mặt dây chuyền Vàng trắng 14K Disney|DAL Minnie alone 0000W001137'), '/image/product/thuonghieu/sp-gm0000w001137-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Mặt dây chuyền Vàng 18K DAL Kim Bảo Như Ý 0000Y001485'), '/image/product/thuonghieu/sp-gm0000y001485-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Mặt dây chuyền Vàng 18K DAL Kim Bảo Như Ý 0000Y001485'), '/image/product/thuonghieu/sp-gm0000y001485-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Mặt dây chuyền Vàng 18K DAL Kim Bảo Như Ý 0000Y001485'), '/image/product/thuonghieu/sp-gm0000y001485-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Mặt dây chuyền Kim cương Vàng trắng 14K DAL DDDDW000957'), '/image/product/thuonghieu/sp-gmddddw000957-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Mặt dây chuyền Kim cương Vàng trắng 14K DAL DDDDW000957'), '/image/product/thuonghieu/sp-gmddddw000957-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Mặt dây chuyền Kim cương Vàng trắng 14K DAL DDDDW000957'), '/image/product/thuonghieu/sp-gmddddw000957-3.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Mặt dây chuyền Kim cương Vàng trắng 14K DAL DDDDW002605'), '/image/product/thuonghieu/sp-gmddddw002605-1.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Mặt dây chuyền Kim cương Vàng trắng 14K DAL DDDDW002605'), '/image/product/thuonghieu/sp-gmddddw002605-2.png'),
((SELECT TOP 1 product_id FROM Products WHERE title = N'Mặt dây chuyền Kim cương Vàng trắng 14K DAL DDDDW002605'), '/image/product/thuonghieu/sp-gmddddw002605-3.png');
;

--scart6 //chuan chua
INSERT INTO ShoppingCart (user_id,exemple_id, quantity)
VALUES 
(1, 2, 1),
(2, 1,2);
--rev7
INSERT INTO Reviews (user_id, product_id, rating, comment)
VALUES 
(1, (SELECT product_id FROM Products WHERE title = N'Nhẫn cưới nam Kim cương Vàng 18K DAL DD00Y003449'), 5, N'Sản phẩm tuyệt vời!'),
(2, (SELECT product_id FROM Products WHERE title = N'Nhẫn cưới nam Kim cương Vàng 18K DAL DD00Y003449'), 4, N'Rất đẹp và tinh xảo'),
(1, (SELECT product_id FROM Products WHERE title = N'Cặp nhẫn cưới Vàng trắng 14K DAL Trầu cau 02804-11767'), 5, N'Tôi rất hài lòng với sản phẩm này');

-- Chèn dữ liệu vào bảng Favorites8
INSERT INTO Favorites (user_id, product_id)
VALUES 
((SELECT user_id FROM Users WHERE username = 'duongbill'), (SELECT product_id FROM Products WHERE title = N'Nhẫn cưới nam Kim cương Vàng 18K PNJ DD00Y003449')),
((SELECT user_id FROM Users WHERE username = 'duyanh'), (SELECT product_id FROM Products WHERE title = N'Cặp nhẫn cưới Vàng trắng 14K PNJ Trầu cau 02804-11767'));

--add9
INSERT INTO Addresses (user_id, full_name, phone, address_line, city, province, postal_code)
VALUES 
((SELECT user_id FROM Users WHERE username = 'duongbill'), 'Nguyen Duong', '0985082004',  '25 Dich Vong', 'Cau Giay', 'Ha Noi', '12345'),
((SELECT user_id FROM Users WHERE username = 'duyanh'), 'Vu Anh', '0987654321', '58 Trung Hoa', 'Cau Giay', 'Ha Noi', '67890');

--shippunit10
INSERT INTO ShippingUnits (shu_name, description)
VALUES 
(N'Giao hàng nhanh', N'Dịch vụ giao hàng nhanh chóng và an toàn'),
(N'Giao hàng tiết kiệm', N'Dịch vụ giao hàng với chi phí thấp');

--coupon11
INSERT INTO Coupons (code, discount, expiry_date, min_order_amount)
VALUES 
('DISCOUNT10', 10.00, '2026-12-31', 100000.00),
('SAVE20', 20.00, '2026-12-31', 20000000.00),
('DUONGBILL', 58.00, '2026-01-01', 1500000.00),
('SUMMER50', 50.00, '2026-07-01', 500000.00),
('FREESHIP', 0.00, '2026-12-31', 5000.00);


--order12
INSERT INTO Orders (user_id, order_status, total_price, address_id, shu_id, order_code, coupon_id, payment_method)
VALUES 
((SELECT user_id FROM Users WHERE username = 'duongbill'), N'Đang xử lý', 0.00, (SELECT address_id FROM Addresses WHERE full_name = 'Nguyen Duong'), 
 (SELECT shu_id FROM ShippingUnits WHERE shu_name = N'Giao hàng nhanh'), 'ORD001', (SELECT coupon_id FROM Coupons WHERE code = 'DUONGBILL'), N'Thẻ tín dụng'),

((SELECT user_id FROM Users WHERE username = 'duyanh'), N'Đã giao', 500000.00, (SELECT address_id FROM Addresses WHERE full_name = 'Vu Anh'), 
 (SELECT shu_id FROM ShippingUnits WHERE shu_name = N'Giao hàng tiết kiệm'), 'ORD002', (SELECT coupon_id FROM Coupons WHERE code = 'SAVE20'), N'Tiền mặt');


 --orderitems13 // mua ngay
INSERT INTO OrderItems (order_id, exemple_id, quantity, price)
VALUES 
(
    (SELECT TOP 1 order_id FROM Orders WHERE order_code = 'ORD001'), 1, 2, 10000000.00),
(
    (SELECT TOP 1 order_id FROM Orders WHERE order_code = 'ORD001'), 2, 2, 10000000.00),
(
    (SELECT TOP 1 order_id FROM Orders WHERE order_code = 'ORD002'), 5, 2, 10000000.00);



-- Chèn dữ liệu vào bảng Notifications14
INSERT INTO Notifications (user_id, message, is_read)
VALUES 
((SELECT user_id FROM Users WHERE username = 'duongbill'), N'Bạn có một đơn hàng mới.', 0),
((SELECT user_id FROM Users WHERE username = 'duongbill'), N'Đơn hàng của bạn đã được giao.', 1);

go
CREATE TRIGGER UpdateAverageRating
ON Reviews
AFTER INSERT, UPDATE, DELETE
AS
BEGIN
    DECLARE @ProductID INT;

    -- Lấy ProductID từ bảng INSERTED hoặc DELETED (tuỳ trường hợp)
    IF EXISTS (SELECT * FROM INSERTED)
    BEGIN
        SELECT @ProductID = product_id FROM INSERTED;
    END
    ELSE IF EXISTS (SELECT * FROM DELETED)
    BEGIN
        SELECT @ProductID = product_id FROM DELETED;
    END

    -- Tính toán lại đánh giá trung bình cho sản phẩm
    UPDATE Products
    SET AverageRating = (
        SELECT AVG(CAST(rating AS DECIMAL(3, 2)))
        FROM Reviews
        WHERE product_id = @ProductID
    )
    WHERE product_id = @ProductID;
END;
go

CREATE TRIGGER trg_Users_Email_Unique
ON Users
AFTER INSERT, UPDATE
AS
BEGIN
    IF EXISTS (
        SELECT 1
        FROM Users u
        JOIN inserted i ON u.email = i.email
        WHERE u.email IS NOT NULL
        GROUP BY u.email
        HAVING COUNT(*) > 1
    )
    BEGIN
        RAISERROR ('Email must be unique when not NULL', 16, 1);
        ROLLBACK TRANSACTION;
    END
END;
go

CREATE TRIGGER trg_Users_phone_Unique
ON Users
AFTER INSERT, UPDATE
AS
BEGIN
    IF EXISTS (
        SELECT 1
        FROM Users u
        JOIN inserted i ON u.phone = i.phone
        WHERE u.email IS NOT NULL
        GROUP BY u.phone
        HAVING COUNT(*) > 1
    )
    BEGIN
        RAISERROR ('number phone must be unique when not NULL', 16, 1);
        ROLLBACK TRANSACTION;
    END
END;

go 

--tạo froc thêm dữ liệu cho bảng productExemple
--CREATE PROCEDURE insertProductExemple 
--    @product_id INT,
--   @type_id INT,
--    @stock_quantity INT,
--    @price DECIMAL(10, 2),
--    @title NVARCHAR(100)
--AS
--BEGIN
--    DECLARE @exemple_id INT;

    -- Tính toán @exemple_id
--    SELECT @exemple_id = COALESCE(MAX(exemple_id), 0) + 1
--    FROM ProductsExemple
--    WHERE product_id = @product_id AND type_id = @type_id;

    -- Chèn sản phẩm vào bảng
--    INSERT INTO ProductsExemple (exemple_id, product_id, type_id, stock_quantity, price, title)
--    VALUES (@exemple_id, @product_id, @type_id, @stock_quantity, @price, @title);
--END;
go

-- tạo proc thêm dữ liệu cho bảng ProductImages
--CREATE PROCEDURE insertProductImages
--    @ImageURL VARCHAR(255),
--	@ProductID int
--AS
--BEGIN
--   DECLARE @id INT;
--
--    -- Tính toán @exemple_id
--    SELECT @id = COALESCE(MAX(ID), 0) + 1
--    FROM ProductImages
--    WHERE ProductID = @ProductID;
--
    -- Chèn sản phẩm vào bảng
--    INSERT INTO ProductImages (ImageURL,ProductID,ID)
--    VALUES (@ImageURL,@ProductID,@id);
--END;



GO
create PROCEDURE signUp
    @Email VARCHAR(100),
    @password VARCHAR(255)
AS
BEGIN
    SET NOCOUNT ON;

    -- Thêm người dùng mới vào bảng Users
    INSERT INTO Users (username, password)
    VALUES (@Email, @password);

    -- Trả về thông tin user_id vừa được tạo
    SELECT user_id, username
    FROM Users
    WHERE user_id = SCOPE_IDENTITY();
END

GO


create PROCEDURE getPassword
    @login NVARCHAR(50)
AS
BEGIN
    SET NOCOUNT ON;

    IF EXISTS (SELECT 1 FROM Users WHERE username = @login)
    BEGIN
        SELECT password FROM Users WHERE username = @login;
    END
    ELSE IF EXISTS (SELECT 1 FROM Users WHERE email = @login)
    BEGIN
        SELECT password FROM Users WHERE email = @login;
    END
    ELSE
    BEGIN
        SELECT password FROM Users WHERE phone = @login;
    END
END;





-- Tạo bảng Inventory
--CREATE TABLE Inventory (
--    inventory_id INT IDENTITY(1,1) PRIMARY KEY,
--    product_id INT,
--    stock_quantity INT NOT NULL,
--    FOREIGN KEY (product_id) REFERENCES Products(product_id)
--);

-- Tạo bảng Transactions
--CREATE TABLE Transactions (
--    transaction_id INT IDENTITY(1,1) PRIMARY KEY,
--    seller_id INT,
--    buyer_id INT,
--    product_id INT,
--    quantity INT NOT NULL,
--    total_price DECIMAL(10, 2) NOT NULL,
--    transaction_date DATETIME DEFAULT GETDATE(),
--    FOREIGN KEY (seller_id) REFERENCES Users(user_id),
--    FOREIGN KEY (buyer_id) REFERENCES Users(user_id),
--    FOREIGN KEY (product_id) REFERENCES Products(product_id)
--);

go
create PROCEDURE getTopbestSellers
@SL int
as
SELECT TOP (@SL)
    p.product_id,
    p.title,
    p.minPrice,
    p.AverageRating,
    pi.ImageURL AS img,
    p.views
FROM 
    Products p
LEFT JOIN 
    ProductImages pi ON p.product_id = pi.ProductID 
                     AND pi.ID = (
                        SELECT MIN(ID) 
                        FROM ProductImages 
                        WHERE ProductID = p.product_id
                     )
ORDER BY 
    p.views DESC;


go
-- exec getTopbestSellers @SL = 10
go
Create PROCEDURE getItemsNew
@SL int
as
SELECT TOP (@SL)
    p.product_id,
    p.title,
    p.minPrice,
    p.AverageRating,
    pi.ImageURL AS img,
    p.views
FROM 
    Products p
LEFT JOIN 
    ProductImages pi ON p.product_id = pi.ProductID 
                     AND pi.ID = (
                        SELECT MIN(ID) 
                        FROM ProductImages 
                        WHERE ProductID = p.product_id
                     )
ORDER BY 
    p.created_at DESC;



--exec getItemsNew @SL = 80

go
--lấy top10 dòng sản phẩm bất kì
CREATE PROCEDURE getItemsByCategory
	@SL int,
    @CategoryName NVARCHAR(100)
AS
BEGIN
    SELECT TOP (@SL)
        p.product_id,
        p.title,
        p.minPrice,
        p.AverageRating,
        pi.ImageURL AS img,
        p.views
    FROM 
        Products p
    LEFT JOIN 
        ProductImages pi ON p.product_id = pi.ProductID 
                         AND pi.ID = (
                            SELECT MIN(ID) 
                            FROM ProductImages 
                            WHERE ProductID = p.product_id
                         )
    WHERE
        p.category_id = (SELECT category_id FROM Categories WHERE category_name = @CategoryName)
    ORDER BY 
        p.created_at DESC;
END;

--EXEC getItemsByCategory @SL = 10,  @CategoryName = N'Quà tặng';

go
--product view
CREATE PROCEDURE getProductsByCustomer
    @UserID INT
AS
BEGIN
    SET NOCOUNT ON;

    SELECT 
        p.product_id,
        p.title AS product_name,
        ps.size,
        p.minprice,
        pi.ImageURL AS img
    FROM 
        Orders o
    JOIN 
        OrderItems oi ON o.order_id = oi.order_id
    JOIN 
        ProductSize ps ON oi.exemple_id = ps.exemple_id 
    JOIN 
        Products p ON ps.product_id = p.product_id
    LEFT JOIN 
        ProductImages pi ON p.product_id = pi.ProductID
                         AND pi.ID = (
                            SELECT MIN(ID)
                            FROM ProductImages
                            WHERE ProductID = p.product_id
                         )
    WHERE 
        o.user_id = @UserID;
END;
go
--EXEC getProductsByCustomer @UserID = 1;

--DROP PROCEDURE IF EXISTS getProductsByCustomer;
-- view lay thong bao

go
CREATE PROCEDURE NotificationsUser
@username VARCHAR(50)
AS
SELECT 
    n.notification_id,
    n.message,
    n.created_at,
    n.is_read
FROM 
    Notifications n, Users
where Users.username = @username and Users.user_id = n.user_id 



-- select sp
SELECT 
    p.product_id,
    p.title AS product_name,
    p.description,
    pi.ImageURL AS img,
    SUM(oi.quantity) AS quantity_sold,
    p.minPrice
FROM 
    Products p
LEFT JOIN 
    ProductSize ps ON p.product_id = ps.product_id
LEFT JOIN 
    ProductImages pi ON p.product_id = pi.ProductID
                     AND pi.ID = (
                        SELECT MIN(ID)
                        FROM ProductImages
                        WHERE ProductID = p.product_id
                     )
LEFT JOIN 
    OrderItems oi ON ps.exemple_id = oi.exemple_id
GROUP BY 
    p.product_id, p.title, p.description, pi.ImageURL, p.minPrice
ORDER BY 
    quantity_sold DESC;

go
-- lay san pham chi tiet theo id
create PROCEDURE ProductDetailsContent
@ProductID int
AS
SELECT 
    p.product_id,
    p.title ,
    p.description,
	p.minPrice,
	p.views,
	p.AverageRating
FROM 
    Products p 
where p.product_id = @ProductID

-- exec ProductDetailsContent @ProductID = 1

go
create PROCEDURE productDetailImages
@product int
as
select 
	ImageURL
from ProductImages
where ProductID = @product;

go
--exec productDetailImages @product = 1;

select * from Products

go


CREATE PROCEDURE getProductsByCategory
@categoryId INT,
@SL INT
AS
BEGIN
    SELECT TOP (@SL)
        p.product_id,
        p.title,
        p.minPrice,
        p.AverageRating,
        pi.ImageURL AS img,
        p.views
    FROM 
        Products p
    LEFT JOIN 
        ProductImages pi ON p.product_id = pi.ProductID 
                         AND pi.ID = (
                            SELECT MIN(ID) 
                            FROM ProductImages 
                            WHERE ProductID = p.product_id
                         )
    WHERE 
        p.category_id = @categoryId
    ORDER BY 
        p.created_at DESC;
END;

--EXEC getProductsByCategory @SL = 20,  @CategoryId = 1;
go


--ham nay de lay min max luot ban

CREATE PROCEDURE getMinMaxSell
@categoryId INT,
@SL INT,
@sortBy NVARCHAR(50) -- Thêm tham số sortBy để xác định cách sắp xếp
AS
BEGIN
    IF @sortBy = 'price_asc'
    BEGIN
        SELECT TOP (@SL)
            p.product_id,
            p.title,
            p.minPrice,
            p.AverageRating,
            pi.ImageURL AS img,
            p.views
        FROM 
            Products p
        LEFT JOIN 
            ProductImages pi ON p.product_id = pi.ProductID 
                             AND pi.ID = (
                                SELECT MIN(ID) 
                                FROM ProductImages 
                                WHERE ProductID = p.product_id
                             )
        WHERE 
            p.category_id = @categoryId
        ORDER BY 
            p.minPrice ASC;
    END
    ELSE IF @sortBy = 'price_desc'
    BEGIN
        SELECT TOP (@SL)
            p.product_id,
            p.title,
            p.minPrice,
            p.AverageRating,
            pi.ImageURL AS img,
            p.views
        FROM 
            Products p
        LEFT JOIN 
            ProductImages pi ON p.product_id = pi.ProductID 
                             AND pi.ID = (
                                SELECT MIN(ID) 
                                FROM ProductImages 
                                WHERE ProductID = p.product_id
                             )
        WHERE 
            p.category_id = @categoryId
        ORDER BY 
            p.minPrice DESC;
    END
    ELSE IF @sortBy = 'sales'
    BEGIN
        SELECT TOP (@SL)
            p.product_id,
            p.title,
            p.minPrice,
            p.AverageRating,
            pi.ImageURL AS img,
            p.views
        FROM 
            Products p
        LEFT JOIN 
            ProductImages pi ON p.product_id = pi.ProductID 
                             AND pi.ID = (
                                SELECT MIN(ID) 
                                FROM ProductImages 
                                WHERE ProductID = p.product_id
                             )
        WHERE 
            p.category_id = @categoryId
        ORDER BY 
            p.views DESC; -- Giả định số lượt bán được lưu trong cột views
    END
    ELSE
    BEGIN
        SELECT TOP (@SL)
            p.product_id,
            p.title,
            p.minPrice,
            p.AverageRating,
            pi.ImageURL AS img,
            p.views
        FROM 
            Products p
        LEFT JOIN 
            ProductImages pi ON p.product_id = pi.ProductID 
                             AND pi.ID = (
                                SELECT MIN(ID) 
                                FROM ProductImages 
                                WHERE ProductID = p.product_id
                             )
        WHERE 
            p.category_id = @categoryId
        ORDER BY 
            p.created_at DESC;
    END
END;

-- Sắp xếp giá từ thấp lên cao
--EXEC getMinMaxSell @categoryId = 1, @SL = 20, @sortBy = 'price_asc';

-- Sắp xếp giá từ cao xuống thấp
--EXEC getMinMaxSell @categoryId = 1, @SL = 20, @sortBy = 'price_desc';

-- Sắp xếp theo lượt bán

--EXEC getMinMaxSell @categoryId = 4, @SL = 20, @sortBy = 'sales';



go

-- thu tuc lay ds order theo id - mua ngay
create PROCEDURE GetUserOrderProducts
    @UserId INT
AS
BEGIN
    ;WITH FirstImage AS (
        SELECT 
            p.product_id,
            MIN(pi.ImageURL) AS ImageURL
        FROM 
            Products p
        LEFT JOIN 
            ProductImages pi ON p.product_id = pi.ProductID
        GROUP BY 
            p.product_id
    ), DefaultSizeQuantity AS (
        SELECT 
            ps.product_id,
            MIN(ps.size) AS size,
            1 AS default_quantity -- Mặc định số lượng là 1
        FROM 
            ProductSize ps
        GROUP BY 
            ps.product_id
    )
    SELECT 
        p.title,
        COALESCE(ps.size, dsq.size) AS size, -- Lấy kích thước từ ProductSize nếu có, nếu không thì lấy kích thước mặc định
        COALESCE(oi.quantity, dsq.default_quantity) AS order_quantity, -- Lấy số lượng từ OrderItems nếu có, nếu không thì lấy số lượng mặc định là 1
        p.minPrice AS price, -- Lấy giá từ bảng Products
        fi.ImageURL
    FROM 
        Orders o
    LEFT JOIN 
        OrderItems oi ON o.order_id = oi.order_id
    LEFT JOIN 
        ProductSize ps ON oi.exemple_id = ps.exemple_id
    LEFT JOIN 
        Products p ON ps.product_id = p.product_id
    LEFT JOIN 
        FirstImage fi ON p.product_id = fi.product_id
    LEFT JOIN 
        DefaultSizeQuantity dsq ON p.product_id = dsq.product_id
    WHERE 
        o.user_id = @UserId;
END;

go 

--EXEC GetUserOrderProducts @UserId = 1;
go

create PROCEDURE GetUserCartProducts
    @UserId INT
AS
BEGIN
    ;WITH FirstImage AS (
        SELECT 
            p.product_id,
            MIN(pi.ImageURL) AS ImageURL
        FROM 
            Products p
        LEFT JOIN 
            ProductImages pi ON p.product_id = pi.ProductID
        GROUP BY 
            p.product_id
    ), DefaultSizeQuantity AS (
        SELECT 
            ps.product_id,
            MIN(ps.size) AS size,
            1 AS default_quantity -- Mặc định số lượng là 1
        FROM 
            ProductSize ps
        GROUP BY 
            ps.product_id
    )
    SELECT 
        p.title,
        COALESCE(ps.size, dsq.size) AS size, -- Lấy kích thước từ ProductSize nếu có, nếu không thì lấy kích thước mặc định
        COALESCE(sc.quantity, dsq.default_quantity) AS cart_quantity, -- Lấy số lượng từ ShoppingCart nếu có, nếu không thì lấy số lượng mặc định là 1
        p.minPrice AS price, -- Lấy giá từ bảng Products
        fi.ImageURL
    FROM 
        ShoppingCart sc
    LEFT JOIN 
        ProductSize ps ON sc.exemple_id = ps.exemple_id
    LEFT JOIN 
        Products p ON ps.product_id = p.product_id
    LEFT JOIN 
        FirstImage fi ON p.product_id = fi.product_id
    LEFT JOIN 
        DefaultSizeQuantity dsq ON p.product_id = dsq.product_id
    WHERE 
        sc.user_id = @UserId;
END;


--EXEC GetUserCartProducts @UserId = 2;


go



CREATE PROCEDURE GetProductSizeByProductId
    @ProductId INT
AS
BEGIN
    SELECT exemple_id, size , stock_quantity
    FROM ProductSize
    WHERE product_id = @ProductId;
END;


go
create PROCEDURE getUserInfo
    @login NVARCHAR(50),
    @password NVARCHAR(255)
AS
BEGIN
    SET NOCOUNT ON;

    -- Kiểm tra xem tài khoản có tồn tại và mật khẩu có đúng không
    IF EXISTS (SELECT 1 FROM Users WHERE (username = @login OR email = @login OR phone = @login) AND password = @password)
    BEGIN
        -- Trả về thông tin người dùng khi cả login và password đều khớp
        SELECT 
            user_id, 
            username, 
            email, 
            phone, 
            first_name, 
            last_name,
			address_line,
			city,
			province
        FROM Users 
        WHERE (username = @login OR email = @login OR phone = @login) AND password = @password;
    END
    ELSE
    BEGIN
        -- Nếu không tìm thấy, trả về thông báo lỗi hoặc giá trị NULL
        SELECT NULL AS ErrorMessage;
    END
END;

go

create PROCEDURE GetCart

    @UserId INT
AS
BEGIN
    ;WITH FirstImage AS (
        SELECT 
            p.product_id,
            MIN(pi.ImageURL) AS ImageURL
        FROM 
            Products p
        LEFT JOIN 
            ProductImages pi ON p.product_id = pi.ProductID
        GROUP BY 
            p.product_id
    )
    SELECT 
		p.product_id,
        ps.exemple_id,
        p.title,
        ps.size,
		ps.stock_quantity,
        p.minPrice AS price,
        fi.ImageURL
    FROM 
        ShoppingCart sc
    LEFT JOIN 
        ProductSize ps ON sc.exemple_id = ps.exemple_id
    LEFT JOIN 
        Products p ON ps.product_id = p.product_id
    LEFT JOIN 
        FirstImage fi ON p.product_id = fi.product_id
    WHERE 
        sc.user_id = @UserId
END;


--EXEC GetCart @UserId = 1;
go
CREATE PROCEDURE TimKiemSanPham
    @TuKhoa NVARCHAR(100)
AS
BEGIN
    SELECT * 
    FROM Products
    WHERE title LIKE '%' + @TuKhoa + '%'
END

--EXEC TimKiemSanPham @TuKhoa = N'00';

go
create PROCEDURE AddToCart
    @UserID INT,
    @SizeID INT
AS
BEGIN
    DECLARE @ProductID INT
    DECLARE @Price DECIMAL(10, 2)
    DECLARE @Title NVARCHAR(100)
    DECLARE @ImageURL NVARCHAR(255)
    DECLARE @Size INT

    -- Lấy ProductID, Price, Title, ImageURL và Size từ ProductSize và Products
    SELECT 
        @ProductID = ps.product_id, 
        @Price = p.minPrice,
        @Title = p.title,
        @ImageURL = pi.ImageURL,
        @Size = ps.size
    FROM ProductSize ps
    JOIN Products p ON ps.product_id = p.product_id
    LEFT JOIN (SELECT ProductID, MIN(ImageURL) AS ImageURL FROM ProductImages GROUP BY ProductID) pi ON pi.ProductID = p.product_id
    WHERE ps.exemple_id = @SizeID

    -- Kiểm tra nếu sản phẩm đã có trong giỏ hàng của người dùng
    IF EXISTS (SELECT 1 FROM ShoppingCart WHERE user_id = @UserID AND exemple_id = @SizeID)
    BEGIN
        -- Nếu sản phẩm đã tồn tại, cập nhật số lượng
        UPDATE ShoppingCart
        SET quantity = quantity + 1
        WHERE user_id = @UserID AND exemple_id = @SizeID
    END
    ELSE
    BEGIN
        -- Nếu sản phẩm chưa tồn tại, thêm mới vào giỏ hàng
        INSERT INTO ShoppingCart (user_id, exemple_id, quantity)
        VALUES (@UserID, @SizeID, 1)
    END
    
    -- Trả về thông tin sản phẩm cho vào giỏ hàng
    SELECT 
        @ProductID AS ProductID,
        @Title AS Title,
        @Price AS Price,
        @ImageURL AS ImageURL,
        @Size AS Size
END


-- Giả sử bạn có người dùng với UserID là 1 và SizeID là 2
--EXEC AddToCart @UserID = 1, @SizeID = 2;
