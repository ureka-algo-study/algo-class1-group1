package seoa.LeetCode;

import java.util.Stack;

public class LeetCode_20_ValidParentheses {
	public boolean isValid(String s) {
		Stack<Character> bStack = new Stack<>();
		
		for (int i = 0; i<s.length(); i++) {
			char token = s.charAt(i);
			if (token == '(' || token == '{' || token == '[') {
				bStack.push(token);
			} else {
				if (!bStack.isEmpty()) {
					Character peek = bStack.peek();
					if (peek == '(' || peek == '{' || peek == '[') {
						switch (token) {
							case ')': {
								if (peek =='(') {
									bStack.pop();
								} else {
									return false;
								}
								break;
							}
							case '}' : {
								if (peek =='{') {
									bStack.pop();
								} else {
									return false;
								}
								break;
							}
							case ']' : {
								if (peek =='[') {
									bStack.pop();
								} else {
									return false;
								}
								break;
							}
						}
					}
				} else {
					return false;
				}
			}
		}
		if (!bStack.isEmpty()) {
			return false;
		}
		return true;
	}
}
