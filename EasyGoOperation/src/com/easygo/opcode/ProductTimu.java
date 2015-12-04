package com.easygo.opcode;

import java.util.Random;

public class ProductTimu {

	private int a = 0, b = 0, c = 0, d = 0, temp;
	private String op = "+", op1 = "+", op2 = "+";
	private int opnum = 0, opnum1 = 0, opnum2 = 0;
	private int optype = 0, optype1 = 0, optype2 = 0;// πÈ¿‡
	private int biaodashitype = 0;
	private String str = "";

	/*public static void main(String args[]) {
		String str = "";
		ProductTimu test = new ProductTimu();
		for (int i = 0; i < 10; i++) {
			str = test.prod(3);
			System.out.println(str);
		}
	}*/

	public String prod(int diffi) {
		switch (diffi) {
		case 1:
			easy();
			break;
		case 2:
			Medium();
			break;
		case 3:
			hard();
			break;

		default:
			break;
		}
		return str;
	}

	private void easy() {

		Random ra = new Random();

		a = ra.nextInt(40) + 1;
		b = ra.nextInt(40) + 1;

		opnum = Math.abs(ra.nextInt()) % 4 + 1;
		if (a < b) {
			temp = a;
			a = b;
			b = temp;
		}
		switch (opnum) {
		case 1:
			op = "+";
			break;
		case 2:
			op = "-";
			break;
		case 3:
			op = "*";
			break;
		case 4:
			op = "/";
			break;
		}

		if ((op == "-") && (a < b)) {
			temp = a;
			a = b;
			b = temp;
		}

		if (op == "/") {
			if (b == 0) {
				b = 1;
			}
			a = a * b;
		}

		str = a + op + b + "";

	}

	private void Medium() {
		setData();
		Random ra = new Random();
		if (optype > optype1) {
			biaodashitype = Math.abs(ra.nextInt()) % 2 + 1;
			if (biaodashitype == 1) {
				str = a + op + b + op1 + c;
			} else {
				str = a + op + "(" + b + op1 + c + ")";
			}
		} else if (optype < optype1) {
			biaodashitype = Math.abs(ra.nextInt()) % 2 + 1;
			if (biaodashitype == 1) {
				str = a + op + b + op1 + c;
			} else {
				str = "(" + a + op + b + ")" + op1 + c;
			}
		} else {
			str = a + op + b + op1 + c;
		}
	}

	private void setData() {
		Random random = new Random();
		opnum = Math.abs(random.nextInt()) % 4 + 1;
		opnum1 = Math.abs(random.nextInt()) % 4 + 1;
		opnum2 = Math.abs(random.nextInt()) % 4 + 1;
		if (opnum < 3) {
			optype = 1;
		} else {
			optype = 2;
		}
		if (opnum1 < 3) {
			optype1 = 1;
		} else {
			optype1 = 2;
		}
		if (opnum2 < 3) {
			optype2 = 1;
		} else {
			optype2 = 2;
		}
		op = Setop(opnum);
		op1 = Setop(opnum1);
		op2 = Setop(opnum2);
		a = random.nextInt(10) + 1;
		b = random.nextInt(10) + 1;
		c = random.nextInt(10) + 1;
		d = random.nextInt(10) + 1;
	}

	private void hard() {
		setData();
		Random ra = new Random();
		if (optype == optype1 && optype < optype2 && optype1 < optype2) {
			biaodashitype = Math.abs(ra.nextInt()) % 9 + 1;
			if (biaodashitype == 1) {
				str = a + op + b + op1 + c + op2 + d;
			} else if (biaodashitype == 2 || biaodashitype == 5
					|| biaodashitype == 8 || biaodashitype == 4) {
				str = a + op + "(" + b + op1 + c + ")" + op2 + d;
			} else {
				str = "(" + a + op + b + op1 + c + ")" + op2 + d;
			}
		} else if (optype < optype1 && optype == optype2 && optype1 > optype2) {
			biaodashitype = Math.abs(ra.nextInt()) % 12 + 1;
			if (biaodashitype == 1) {
				str = a + op + b + op1 + c + op2 + d;
			} else if (biaodashitype == 2 || biaodashitype == 6
					|| biaodashitype == 10 || biaodashitype == 5) {
				str = "(" + a + op + b + ")" + op1 + c + op2 + d;
			} else if (biaodashitype == 3 || biaodashitype == 7
					|| biaodashitype == 11 || biaodashitype == 9) {
				str = a + op + b + op1 + "(" + c + op2 + d + ")";
			} else {
				str = "(" + a + op + b + ")" + op1 + "(" + c + op2 + d + ")";
			}
		} else if (optype > optype1 && optype == optype2 && optype1 < optype2) {
			biaodashitype = Math.abs(ra.nextInt()) % 2 + 1;
			if (biaodashitype == 1) {
				str = a + op + b + op1 + c + op2 + d;
			} else {
				str = a + op + "(" + b + op1 + c + ")" + op2 + d;
			}
		} else if (optype == optype1 && optype > optype2 && optype1 > optype2) {
			biaodashitype = Math.abs(ra.nextInt()) % 2 + 1;
			if (biaodashitype == 1) {
				str = a + op + b + op1 + c + op2 + d;
			} else {
				str = a + op + b + op1 + "(" + c + op2 + d + ")";
			}
		} else {
			str = a + op + b + op1 + c + op2 + d;
		}
	}

	private String Setop(int op_num) {
		String opStr = "";
		switch (op_num) {
		case 1:
			opStr = "+";
			break;
		case 2:
			opStr = "-";
			break;
		case 3:
			opStr = "*";
			break;
		case 4:
			opStr = "/";
			break;
		}
		return opStr;
	}

}
