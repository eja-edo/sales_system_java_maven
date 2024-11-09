from PIL import Image
import os
from collections import Counter

def calculate_intermediate_sizes(original_size, target_size, num_steps=6):
    # Tính toán kích thước trung gian
    intermediate_sizes = []
    width_ratio = (target_size[0] / original_size[0]) ** (1 / (num_steps + 1))
    height_ratio = (target_size[1] / original_size[1]) ** (1 / (num_steps + 1))

    for i in range(1, num_steps + 1):
        new_width = int(original_size[0] * (width_ratio ** i))
        new_height = int(original_size[1] * (height_ratio ** i))
        intermediate_sizes.append((new_width, new_height))

    return intermediate_sizes

def get_dominant_color(image):
    # Lấy dữ liệu pixel
    pixels = list(image.getdata())
    
    # Lọc bỏ các pixel trong suốt
    non_transparent_pixels = [pixel for pixel in pixels if pixel[3] > 0]
    
    if not non_transparent_pixels:  # Nếu không có pixel nào không trong suốt
        return (0, 0, 0)  # Trả về màu đen hoặc một giá trị mặc định

    # Tính toán màu xuất hiện nhiều nhất
    most_common_color = Counter(non_transparent_pixels).most_common(1)[0][0]
    return most_common_color[:3]  # Trả về chỉ màu RGB

def is_single_color(image):
    # Chuyển đổi ảnh sang chế độ RGBA
    image = image.convert('RGBA')
    
    # Lấy dữ liệu pixel
    pixels = list(image.getdata())
    
    # Lọc bỏ các pixel trong suốt
    non_transparent_pixels = [pixel for pixel in pixels if pixel[3] > 0]
    
    if not non_transparent_pixels:
        return False  # Nếu không có pixel không trong suốt, không phải màu đơn
    
    # Lấy màu đầu tiên làm màu tham chiếu
    first_color = non_transparent_pixels[0]
    
    # Kiểm tra xem tất cả các pixel có cùng màu không
    return all(pixel == first_color for pixel in non_transparent_pixels)

def resize_image(input_path, output_path, target_size, num_steps=6):
    # Mở ảnh gốc
    image = Image.open(input_path)

    if image is None:
        print("Không thể mở ảnh. Kiểm tra lại đường dẫn.")
        return

    original_size = image.size
    print(f"Kích thước gốc: {original_size}")

    # Chuyển đổi ảnh sang chế độ RGBA để giữ lại alpha
    image = image.convert('RGBA')

    # Kiểm tra nếu ảnh có phải màu đơn không
    if is_single_color(image):
        print("Ảnh là màu đơn. Resize trực tiếp về kích thước mục tiêu.")
        image = image.resize(target_size, Image.LANCZOS)
    else:
        # Bước 1: Lấy màu phổ biến nhất từ ảnh gốc
        dominant_color = get_dominant_color(image)
        print(f"Màu phổ biến nhất: {dominant_color}")

        # Bước 2: Tính toán kích thước trung gian
        intermediate_sizes = calculate_intermediate_sizes(original_size, target_size, num_steps)

        # Resize qua từng kích thước trung gian
        for size in intermediate_sizes:
            image = image.resize(size, Image.LANCZOS)
            print(f"Đã resize về kích thước: {size}")

        # Resize về kích thước mục tiêu
        image = image.resize(target_size, Image.LANCZOS)
        print(f"Đã resize về kích thước mục tiêu: {target_size}")

    # Tạo một ảnh mới với cùng kích thước và chế độ RGBA
    final_image = Image.new('RGBA', image.size)

    width, height = image.size
    for x in range(width):
        for y in range(height):
            # Lấy pixel tại vị trí (x, y)
            pixel = image.getpixel((x, y))
            # Giữ giá trị alpha cho pixel trong suốt
            alpha = pixel[3] if len(pixel) == 4 else 255
            
            # Đặt tất cả pixel không trong suốt thành màu phổ biến nhất
            if alpha > 0:  # Nếu pixel không trong suốt
                final_image.putpixel((x, y), (dominant_color[0], dominant_color[1], dominant_color[2], alpha))
            else:  # Nếu pixel trong suốt
                final_image.putpixel((x, y), pixel)  # Giữ nguyên pixel trong suốt

    # Lưu ảnh
    final_image.save(output_path)
    print(f"Ảnh đã được resize và lưu vào {output_path}")

# Đường dẫn vào
input_path = 'original_img/traGop.png'
output_dir = 'icon'

# Tạo thư mục đích nếu chưa tồn tại
if not os.path.exists(output_dir):
    os.makedirs(output_dir)

# Kích thước mục tiêu
w = int(input("Nhập vào width: "))
h = int(input("Nhập vào height: "))
target_size = (w, h)

# Tạo tên file mới dựa trên tên file cũ và kích thước
base_name = os.path.basename(input_path)  # Lấy tên file cũ
name, ext = os.path.splitext(base_name)   # Tách tên file và phần mở rộng
output_filename = f"{name}_{w}x{h}{ext}"  # Tạo tên file mới
output_path = os.path.join(output_dir, output_filename)

# Resize ảnh
resize_image(input_path, output_path, target_size)
