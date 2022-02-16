package stock.dto;

import java.util.List;

public class FigiesDto {
	private List<String> figies;

	
	public FigiesDto() {
		super();
	}

	public FigiesDto(List<String> figies) {
		super();
		this.figies = figies;
	}

	public List<String> getFigies() {
		return figies;
	}

	public void setFigies(List<String> figies) {
		this.figies = figies;
	}
	
	
}
