package hello.thymeleaf.basic.itemservice.web.validation;

import hello.thymeleaf.basic.itemservice.domain.item.Item;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ItemValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Item.class.isAssignableFrom(clazz);
        //item == clazz 타입 비교
        //item == subItem 상속비교
    }

    @Override
    public void validate(Object target, Errors bindResult) {
        Item item = (Item) target;
        //검증 로직
        if (!StringUtils.hasText(item.getItemName())) {
            bindResult.rejectValue("itemName", "required");
        }

        if (item.getPrice() == null || item.getPrice() < 1000 || item.getPrice() > 1000000) {
            bindResult.rejectValue("price", "range", new Object[]{1000, 1000000}, null);
        }
        if (item.getQuantity() == null || item.getQuantity() >= 9999) {
            bindResult.rejectValue("quantity", "max", new Object[]{9999}, null);
        }
        if (item.getPrice() != null && item.getQuantity() != null) {
            int resultPrice = item.getQuantity() * item.getPrice();
            if (resultPrice < 10000) {
                bindResult.reject("totalPriceMin", new Object[]{10000, resultPrice}, null);
            }
        }
    }
}
