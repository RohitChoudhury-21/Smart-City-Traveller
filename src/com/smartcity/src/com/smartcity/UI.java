package com.smartcity;
});


root.setTop(topBar);
root.setCenter(table);
root.setRight(rightPane);


Scene scene = new Scene(root, 1000, 600);
primaryStage.setScene(scene);
primaryStage.show();


// initial load
loadAll();
}


private void loadAll() {
List<Location> list = db.getAllLocations();
tableData.clear();
for (Location l : list) tableData.add(new LocationRow(l));
}


private void runSearch(String q) {
if (q == null || q.trim().isEmpty()) {
loadAll();
return;
}
List<Location> list = db.searchLocations(q.trim());
tableData.clear();
for (Location l : list) tableData.add(new LocationRow(l));
}


// Small wrapper used by TableView (JavaFX requires properties or simple getters)
public static class LocationRow {
private final int id;
private final String name;
private final String category;
private final String address;
private final String description;


public LocationRow(Location l) {
this.id = l.id;
this.name = l.name;
this.category = l.category;
this.address = l.address;
this.description = l.description;
}


public int getId() { return id; }
public String getName() { return name; }
public String getCategory() { return category; }
public String getAddress() { return address; }
public String getDescription() { return description; }
}
}
