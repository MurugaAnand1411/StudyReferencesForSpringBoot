INSERT INTO public.category(
	category_id, category_name, img_url)
	VALUES (1, 'Vegetables', 'http://localhost:8080/product/images/getImage/vege.jpg');
INSERT INTO public.category(
	category_id, category_name, img_url)
	VALUES (2, 'Fruits', 'http://localhost:8080/product/images/getImage/fruits.jpg');
INSERT INTO public.category(
	category_id, category_name, img_url)
	VALUES (3, 'Dairy', 'http://localhost:8080/product/images/getImage/Dairy.jpg');

	
INSERT INTO public.product(
	product_id, description, img_url, price, product_name, category_id)
	VALUES (1, 'Good and organic', 'http://localhost:8080/product/images/getImage/tomatos.jpg', 23.66,'Tomatos',1);
	
INSERT INTO public.product(
	product_id, description, img_url, price, product_name, category_id)
	VALUES (2, 'Fresh and Organic', 'http://localhost:8080/product/images/getImage/brocolli.jpg', 35.45,'Brocolli',1);
INSERT INTO public.product(
	product_id, description, img_url, price, product_name, category_id)
	VALUES (3, 'Sweet and Sour', 'http://localhost:8080/product/images/getImage/mango.jpg', 45.45,'Mango',2);
INSERT INTO public.product(
	product_id, description, img_url, price, product_name, category_id)
	VALUES (4, 'Organic', 'http://localhost:8080/product/images/getImage/avagado.jpg', 36.85,'Avagado',2);
INSERT INTO public.product(
	product_id, description, img_url, price, product_name, category_id)
	VALUES (5, 'Organic', 'http://localhost:8080/product/images/getImage/milk.jpg', 36.85,'Milk',3);
INSERT INTO public.product(
	product_id, description, img_url, price, product_name, category_id)
	VALUES (6, 'Organic', 'http://localhost:8080/product/images/getImage/mozzarella-cheese-500x500.jpg', 36.85,'Cheese',3);

	
INSERT INTO public.ecommuser(
	user_id, address, email_id, is_verified, mobile, name, password, roles)
	VALUES (1, 'No 237, 2nd Cross, Vasan Valley ,Vayalor Road ,Trichy-620102', 'test@gmail.com',true,'7530079486','test','test','customer');