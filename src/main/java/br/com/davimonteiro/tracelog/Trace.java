/**
 * The MIT License
 * Copyright © 2016 Davi Monteiro Barbosa
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package br.com.davimonteiro.tracelog;

import java.util.Stack;

/**
 * 
 * @author Davi Monteiro
 * @since 2016
 * 
 * The {@code Trace} class represents an application trace. Eg.: request, process and response.
 *
 */
public class Trace {
	
	private Stack<String> actions = new Stack<String>();
	
	public void add(String action) {
		actions.push(action);
	}
	
	public String remove() {
		return actions.pop();
	}
	
	public String peek() {
		return actions.peek();
	}
	
	
	public Boolean isEmpty() {
		return actions.empty();
	}
	
	public void removeAll() {
		actions.removeAllElements();
	}
	
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		
		for (int i = 0; i < actions.size(); i++) {
			buffer.append(actions.get(i) + ", ");
		}
		
		return buffer.substring(0, buffer.length() - 2).toString();
	}
	
}
