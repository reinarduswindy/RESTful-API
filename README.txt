RESTful API
Dibuat menggunakan Jersey Framework (Java)

Database :
1. Products. Terdapat 5 record di dalam dengan masing-masing id dari "product1" hingga "product5".
2. Coupons. Terdapat 3 record di dalam dengan masing-masing id dari "coupon1" hingga "coupon3".
3. Cart_products
4. Cart

Link URL = "http://restapi-windyhendra.rhcloud.com/restapi/";

Tambah produk ke dalam cart :
- HOST/CartService/addproduct/{product_id}

Hapus produk di dalam cart :
- HOST/CartService/removeproduct/{product_id}

Menampilkan daftar produk di dalam cart :
- HOST/CartService/cart

Menampilkan total harga pembelian (tanpa kupon) :
- HOST/CartService/payment

Menampilkan total harga pembelian (dengan kupon) :
- HOST/CartService/payment/{coupon_id}
