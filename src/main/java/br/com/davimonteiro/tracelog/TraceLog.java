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

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import lombok.Synchronized;

/**
 * 
 * @author Davi Monteiro
 * @since 2016
 * 
 * This class consists of utility methods for operating on traces.
 *
 */
public class TraceLog {

	private Trace trace;
	
	private static TraceLog instance;
	
	private String path;

	private TraceLog(String path) {
		this.path = path;
		this.trace = new Trace();
	}

	@Synchronized
	public static TraceLog openTrace(String path) {
		if (instance == null) {
			instance = new TraceLog(path);
		}
		return instance;
	}

	@Synchronized
	public TraceLog addAction(String action) {
		trace.add(action);
		return instance;
	}

	@Synchronized
	public String removeAction() {
		return trace.remove();
	}

	@Synchronized
	public String lookAction() {
		return trace.peek();
	}

	@Synchronized
	public Boolean isEmpty() {
		return trace.isEmpty();
	}

	@Synchronized
	public void endTrace() {
		try {
			String traceString = trace.toString() + "\n";
			Files.write(Paths.get(path), traceString.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
			trace.removeAll();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
