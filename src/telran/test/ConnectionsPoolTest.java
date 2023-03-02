package telran.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import telran.util.*;

class ConnectionsPoolTest {
	
	ConnectionPoolImplementation pool = new ConnectionPoolImplementation();
	Connection connection1 = new Connection(1, "192.168.1.2", 8010); 
	Connection connection2 = new Connection(2, "192.168.1.3", 8010); 
	Connection connection3 = new Connection(3, "192.168.1.4", 8010); 
	Connection connection4 = new Connection(4, "192.168.1.5", 8010); 
	Connection connection5 = new Connection(5, "192.168.1.5", 8010); 

	@BeforeEach
	void setUp() throws Exception {	
		pool.addConnection(connection1);
		pool.addConnection(connection2);
		pool.addConnection(connection3);
		pool.addConnection(connection4);
	}

	@Test
	void addConnectionsTest() {
		assertTrue(pool.addConnection(connection5));
		assertFalse(pool.addConnection(connection3));
		assertEquals(2, pool.getOldConnection());
		
	}
	
	@Test
	void getConnection(){
		assertTrue(pool.addConnection(connection5));
		assertEquals(2, pool.getConnection(2).getId());
		assertEquals(3, pool.getOldConnection());
		
	}

}
