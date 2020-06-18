Phát triển ứng dụng Java - Lớp : 16/31
-------------------------------------------------------------------

MSSV	: 1612209
Họ tên	: Nguyễn Hữu Hòa
email	: 1612209@student.hcmus.edu.vn
DĐ	: 0982327118

-------------------------------------------------------------------

Các chức năng đã làm được :
- Tạo từ điển (dict.xml)
- Đọc từ điển
- Tra từ (English & vietnamese)
- Thay đổi ngôn ngữ (*)
- Lưu vào mục ưa thích
- Xem mục ưa thích : A-Z , Z-A (bằng English & vietnamese)
- Thống kê từ ngày XX đến ngày YY (**)

(*) Mô tả chức năng :
có 2 loại ngôn ngữ : en và vi, chọn ngôn ngữ nào thì các chức năng như
tra cứu, xem mục ưa thích hay thống kê sẽ theo ngôn ngữ đó.
(**) Mô tả cách làm : 
Mỗi thao tác tra cứu sẽ mở tập tin "thongke.txt" ghi thêm log
vào cuối file (sử dụng append). (Chỉ ghi thêm 1 dòng mới và không
xóa dữ liệu cũ).
Mỗi khi gọi chức năng thống kê sẽ đọc thông tin từ file và thống
kê cho người dùng.

-------------------------------------------------------------------

Cách cài đặt :
- Để các file "dictionary.java","dict.xml","thongke.txt" cùng 1 thư mục
- Dùng NetBeans IDE để run file. (hỗ trợ tốt nhất font tiếng việt)
- Nếu dùng NetBeans có thể mở trực tiếp project này được.
- Trường hợp chạy console windows vẫn được nhưng sẽ xuất hiện các kí tự
lạ (do console windows không được thiết kế để hỗ trợ utf-8 hoặc unicode).
- Làm theo các chỉ dẫn trong chương trình.
- Gặp vấn đề : xem thư mục Demo.