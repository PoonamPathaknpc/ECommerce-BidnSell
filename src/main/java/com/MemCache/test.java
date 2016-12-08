package com.MemCache;

import java.io.IOException;
import java.net.InetSocketAddress;

import net.spy.memcached.MemcachedClient;

public class test {

	public test() {
		// TODO Auto-generated constructor stub
		
	       try {
			MemcachedClient c = new MemcachedClient(new InetSocketAddress("127.0.0.1",11211));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
