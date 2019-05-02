package projet.gl51.store

class MemoryProductStorage implements  ProductStorage {

	List<Product> productList = []
	Integer id = 1
	
    @Override
    Integer save(Product p) {
		p.id = id
        productList.add(p)
		id += 1
    	return p.id
    }

    @Override
    void update(String id, Product p) {
        Product product = this.getByID(id)
        int indexOfProduct = products.indexOf(product)

         products.add(indexOfProduct,p)
    }

    @Override
    Product getByID(String id) {
        def product = productList.find { it.id == id }
        if(product == null)
        {
          throw new NotExistingProductException("The wanted product is not exist!")
        }
        return product
    }

    @Override
    void delete(String id) {
        def product = getByID(id)
        productList.remove(product)
    }

    @Override
    List<Product> all() {
        return productList
    }
}