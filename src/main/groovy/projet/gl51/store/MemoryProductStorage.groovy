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
		def product = getByID(id)
        def productIndex = productList.indexOf(product)

        p.id = id
        productList.add(productIndex, p)
        productList.remove(product)
        id += 1
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