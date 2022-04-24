package guru.springframework.converters;

import guru.springframework.commands.ProductForm;
import guru.springframework.domain.Product;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by jt on 1/10/17.
 */
@Component
public class ProductFormToProduct implements Converter<ProductForm, Product> {

    private static final Logger log = LoggerFactory.getLogger(ProductFormToProduct.class);

    @Override
    public Product convert(ProductForm productForm) {
        Product product = new Product();
        product.setDescription(productForm.getDescription());
        product.setPrice(productForm.getPrice());
        product.setImageUrl(productForm.getImageUrl());

        if (Optional.ofNullable(productForm.getId()).isPresent()) {
            log.info("convert: productForm - ID: {}", productForm.getId());
            ObjectId objectId;

            if (productForm.getId().isBlank()) {
                objectId = ObjectId.get();
                log.debug("convert: new objectId from Object.get() : {}", objectId);
            }
            else {
                objectId = new ObjectId(productForm.getId());
                log.debug("convert: objectId of productForm : {}", objectId);
            }

            log.debug("convert: objectId is Valid :  {}", ObjectId.isValid(objectId.toString()));

            product.setId(objectId);
        }

        log.info("Product converted from ProductForm : product = {}", product);

        return product;
    }
}
