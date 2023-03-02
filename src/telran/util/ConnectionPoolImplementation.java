package telran.util;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

public class ConnectionPoolImplementation implements ConnectionsPool {
	
	private static final Integer MAX_CONNECTIONS = 4;
	
	private LinkedHashMap<Integer, Connection> poolConnections; 
	private Integer maxConnection;;
	private Integer idOldConnection;
	
	public Integer getMaxConnection() {
		return maxConnection;
	}

	public void setMaxConnection(Integer maxConnection) {
		this.maxConnection = maxConnection;
	}

	public Integer getOldConnection() {
		return idOldConnection;
	}

	@Override
	public boolean addConnection(Connection connection) {
		boolean res = false;
		if (!poolConnections.containsKey(connection.getId())) {
			if (!poolConnections.isEmpty()) {
				if (poolConnections.size() == maxConnection) {		
					poolConnections.remove(idOldConnection);
					moveConnection();
				}
				} else {
					idOldConnection = connection.getId();
				}
			poolConnections.put(connection.getId(), connection);
			res = true;
		} else {
			res = false;
		}		
		return  res;
	}

	private void moveConnection() {
		Set<Integer> set = poolConnections.keySet();
		Iterator<Integer> iterator = set.iterator();
		idOldConnection = iterator.next();
	}

	@Override
	public Connection getConnection(Integer id) {
		Connection res = poolConnections.get(id);
		if (res != null) {
			poolConnections.remove(id);
			addConnection(res);
			moveConnection();
		}
		return res;
	}

	public ConnectionPoolImplementation(Integer maxConnection) {
		super();
		this.poolConnections = new LinkedHashMap<>();
		this.maxConnection = maxConnection;
	}
	
	public ConnectionPoolImplementation() {
		this(MAX_CONNECTIONS);
	
	}
	
	

}
