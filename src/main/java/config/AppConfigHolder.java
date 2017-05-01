package config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Serhii Bilobrov
 * @since 1.7
 */
@Component
@ConfigurationProperties(prefix = "app")
public class AppConfigHolder {

    private String privateKey;

    public AppConfigHolder() {
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }
}
