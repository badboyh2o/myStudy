package com.hqxu.testEnum;

import java.util.Arrays;

/**
 * 枚举类嵌套
 * @author Administrator
 *
 */
public enum Meal{
	
	  APPETIZER(Food.Appetizer.class),
	  MAINCOURSE(Food.MainCourse.class),
	  DESSERT(Food.Dessert.class),
	  COFFEE(Food.Coffee.class);
	  
	  //字段
	  private Food[] values;
	  
	  //构造函数
	  private Meal(Class<? extends Food> kind) {
		  values = kind.getEnumConstants();  //通过class对象获取枚举实例
	  }
	  
	  
	  /**
	   * 使用接口管理枚举类
	   * @author Administrator
	   *
	   */
	  public interface Food {
	    enum Appetizer implements Food {
	      SALAD, SOUP, SPRING_ROLLS;
	    }
	    enum MainCourse implements Food {
	      LASAGNE, BURRITO, PAD_THAI,
	      LENTILS, HUMMOUS, VINDALOO;
	    }
	    enum Dessert implements Food {
	      TIRAMISU, GELATO, BLACK_FOREST_CAKE,
	      FRUIT, CREME_CARAMEL;
	    }
	    enum Coffee implements Food {
	      BLACK_COFFEE, DECAF_COFFEE, ESPRESSO,
	      LATTE, CAPPUCCINO, TEA, HERB_TEA;
	    }
	  }
	  
	  public static void main(String[] args) {
		  System.out.println(Arrays.toString(Meal.APPETIZER.values));
	  }
	  
	  
	  
} 
