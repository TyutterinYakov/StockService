package stock.config;

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix="api")
public class ApiConfig {
	private Boolean isSandBoxMode;

	public Boolean getIsSandBoxMode() {
		return isSandBoxMode;
	}

	public void setIsSandBoxMode(Boolean isSandBoxMode) {
		this.isSandBoxMode = isSandBoxMode;
	}
	
	
}
