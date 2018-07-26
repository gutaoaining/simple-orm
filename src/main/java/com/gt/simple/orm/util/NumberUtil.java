package com.gt.simple.orm.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class NumberUtil {

    /**
     * 
     * 描述：浮点数保留几位小数
     * @author gt
     * @param ft 数字字符串
     * @param param 格式化表达式
     * @return 保留结果
     */
    public static double formatStringToNum(String ft, String param){
	    BigDecimal bigNum = new BigDecimal(Double.parseDouble(ft));
    	DecimalFormat decimalFormat = new DecimalFormat(param);
    	decimalFormat.setRoundingMode(RoundingMode.HALF_EVEN);
    	String  result = decimalFormat.format(bigNum);
        return Double.parseDouble(result);
   }
}
