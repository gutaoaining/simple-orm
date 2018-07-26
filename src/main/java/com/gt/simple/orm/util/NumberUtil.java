package com.gt.simple.orm.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class NumberUtil {

    /**
     * 
     * ������������������λС��
     * @author gt
     * @param ft �����ַ���
     * @param param ��ʽ�����ʽ
     * @return �������
     */
    public static double formatStringToNum(String ft, String param){
	    BigDecimal bigNum = new BigDecimal(Double.parseDouble(ft));
    	DecimalFormat decimalFormat = new DecimalFormat(param);
    	decimalFormat.setRoundingMode(RoundingMode.HALF_EVEN);
    	String  result = decimalFormat.format(bigNum);
        return Double.parseDouble(result);
   }
}
