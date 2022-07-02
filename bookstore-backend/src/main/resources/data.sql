INSERT  INTO categories(id, title) VALUES (1,'DevOps'),
                                           (6,'Programming'),
                                           (11,'Security'),
                                           (15,'Litterature');


INSERT  INTO books(id, authors, description, imageurl, price, title, category_id) VALUES (2,' Mikael Krief','Some description Lorem ipsum Lorem ipsum','https://static.packt-cdn.com/products/9781838642730/cover/smaller',10.00,'Learning DevOps',1),
                          (3,'Jeff Nickoloff and Stephen Kuenzli','Some description Lorem ipsum Lorem ipsum','https://drek4537l1klr.cloudfront.net/nickoloff2/Figures/cover.jpg',10.00,'Docker in action, 2nd Edition',1),
                          (4,'Brendan Burns, Joe Beda, Kelsey Hightower','Some description Lorem ipsum Lorem ipsum','https://covers.oreilly.com/images/0636920223788/cat.gif',10.00,'Kubernetes: Up and Running, 2nd Edition',1),
                          (5,'Rafal Leszko','Some description Lorem ipsum Lorem ipsum','https://images-na.ssl-images-amazon.com/images/I/41lPh+vZh2L._SX404_BO1,204,203,200_.jpg',10.00,'Continuous Delivery with Docker and Jenkins',1),
                          (7,'Kathy Sierra','Some description Lorem ipsum Lorem ipsum','https://images-na.ssl-images-amazon.com/images/I/51ptF7BSDYL._SX403_BO1,204,203,200_.jpg',10.00,'Java OCA',6),
                          (8,'Craig Walls','Some description Lorem ipsum Lorem ipsum','https://learning.oreilly.com/library/cover/9781617294945/250w/',10.00,'Spring In Action',6),
                          (9,'Jeremy Wilken','Some description Lorem ipsum Lorem ipsum','https://images-na.ssl-images-amazon.com/images/I/41Vs-83rPxL._SX258_BO1,204,203,200_.jpg',10.00,'Angular In Action',6),
                          (10,'The GOF','Some description Lorem ipsum Lorem ipsum','https://images-na.ssl-images-amazon.com/images/I/51kuc0iWoKL._SX326_BO1,204,203,200_.jpg',10.00,'GOF Design patterns',6),
                          (12,'Tony Hsiang-Chih Hsu','Some description Lorem ipsum Lorem ipsum','https://m.media-amazon.com/images/I/51gG+OsDaqL._SX260_.jpg',10.00,'Hands-On Security in Devops',11),
                          (13,'Andrew Hoffman','Some description Lorem ipsum Lorem ipsum','https://d1w7fb2mkkr3kw.cloudfront.net/assets/images/book/lrg/9781/4920/9781492053118.jpg',10.00,'Web Application Security',11),
                          (14,'Kaizhe Huang, Pranjal Jumde','Some description Lorem ipsum Lorem ipsum','https://images-na.ssl-images-amazon.com/images/I/513cFVYyqmL._SX404_BO1,204,203,200_.jpg',10.00,'Kubernetes Security',11),
                          (16,'Victor Hugo','Some description Lorem ipsum Lorem ipsum','https://m.media-amazon.com/images/I/510ypkdwIYL.jpg',10.00,'Les misérables',15),
                          (17,'Jean Paul Sartre','Some description Lorem ipsum Lorem ipsum','https://images-na.ssl-images-amazon.com/images/I/41MSHBns7WL._SX210_.jpg',10.00,'L\'être et le néant',15),
                          (18,'Albert Camus','Some description Lorem ipsum Lorem ipsum','https://static.fnac-static.com/multimedia/Images/FR/NR/1c/f9/01/129308/1540-0/tsp20191030070736/L-Etranger.jpg',10.00,'L\'étranger',15),
                          (19,'Miguel de Cervantes Saavedra','Some description Lorem ipsum Lorem ipsum','https://static.fnac-static.com/multimedia/Images/FR/NR/92/eb/74/7662482/1540-1/tsp20201218074133/Don-Quichotte.jpg',10.00,'Don Quichotte',15);
