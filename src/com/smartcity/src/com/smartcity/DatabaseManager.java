package com.smartcity;
rs.getString("name"),
rs.getString("category"),
rs.getString("address"),
rs.getString("description")
);
list.add(loc);
}
} catch (SQLException e) {
e.printStackTrace();
}
return list;
}

public List<Location> searchLocations(String q) {
String sql = "SELECT id, name, category, address, description FROM locations WHERE LOWER(name) LIKE ? OR LOWER(category) LIKE ? ORDER BY name";
List<Location> list = new ArrayList<>();
String param = "%" + q.toLowerCase() + "%";

try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
PreparedStatement ps = conn.prepareStatement(sql)) {

ps.setString(1, param);
ps.setString(2, param);

try (ResultSet rs = ps.executeQuery()) {
while (rs.next()) {
Location loc = new Location(
rs.getInt("id"),
rs.getString("name"),
rs.getString("category"),
rs.getString("address"),
rs.getString("description")
);
list.add(loc);
}
}
} catch (SQLException e) {
e.printStackTrace();
}
return list;
}

// Simple holder class used by DatabaseManager and UI
public static class Location {
public final int id;
public final String name;
public final String category;
public final String address;
public final String description;

public Location(int id, String name, String category, String address, String description) {
this.id = id;
this.name = name;
this.category = category;
this.address = address;
this.description = description;
}
}
}
