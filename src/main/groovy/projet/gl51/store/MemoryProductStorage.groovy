package gl51.project.store

class MemoryProductStorage implements  ProductStorage {

	List<Product> productList = []
	Integer id = 1
	
    @Override
    void save(Product p) {
		p.id = id
        productList.add(p)
		id += 1
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