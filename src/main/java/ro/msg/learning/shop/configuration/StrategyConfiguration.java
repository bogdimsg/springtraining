package ro.msg.learning.shop.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.msg.learning.shop.service.impl.LocationServiceImpl;
import ro.msg.learning.shop.service.impl.ProductServiceImpl;
import ro.msg.learning.shop.strategy.OrderStrategy;
import ro.msg.learning.shop.strategy.impl.MostAbundantImpl;
import ro.msg.learning.shop.strategy.impl.SingleLocationImpl;

@Configuration
public class StrategyConfiguration
{
    @Bean
    @ConditionalOnProperty(prefix = "shop", name = "strategy", havingValue = "single")
    public OrderStrategy singleLocationStrategy(LocationServiceImpl locationService, ProductServiceImpl productService)
    {
        return new SingleLocationImpl(locationService, productService);
    }

    @Bean
    @ConditionalOnProperty(prefix = "shop", name = "strategy", havingValue = "most")
    public OrderStrategy mostAbundantStrategy(LocationServiceImpl locationService, ProductServiceImpl productService)
    {
        return new MostAbundantImpl(locationService, productService);
    }
}
