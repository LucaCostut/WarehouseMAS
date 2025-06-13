# 🏭 Warehouse Multi-Agent System (JADE)

This project simulates a smart warehouse using intelligent agents built with the JADE framework.  
Agents collaborate to process orders through picking, packing, delivery, and logging.

## 💡 Agent Roles

- **OrderAgent**: Receives a customer order and sends a request to the Picker
- **PickerAgent**: Picks the requested item and informs the Packer
- **PackerAgent**: Packs the item and passes it to the Transport
- **TransportAgent**: Simulates delivery and informs the Manager
- **ManagerAgent**: Logs final delivery status

---

## 🚀 How to Run the Application

### ✅ Prerequisites

- Java JDK 8 or newer
- [JADE Framework](https://jade.tilab.com/)
- VS Code with Java Extension Pack (or IntelliJ / Eclipse)

### 📦 Download JADE

1. Download from: [JADE Download Page](https://jade.tilab.com/dl.php?file=jadeBin-4.5.0.zip)
2. Extract it and copy `jade.jar` into a folder called `lib/` inside this project

---

## 🛠 Project Structure

```
WarehouseMAS/
├── src/
│   ├── agents/
│   │   ├── OrderAgent.java
│   │   ├── PickerAgent.java
│   │   ├── PackerAgent.java
│   │   ├── TransportAgent.java
│   │   └── ManagerAgent.java
│   └── WarehouseAgentLauncher.java
├── lib/
│   └── jade.jar
├── out/
├── .gitignore
└── README.md
```

---

## 🧪 Compile and Run (Terminal)

### 💻 On macOS / Linux:

```bash
cd WarehouseMAS

# Compile
javac -cp "lib/jade.jar" -d out src/agents/*.java src/WarehouseAgentLauncher.java

# Run
java -cp "out:lib/jade.jar" WarehouseAgentLauncher
```

### 🪟 On Windows:

```cmd
cd WarehouseMAS

javac -cp "lib\jade.jar" -d out src\agents\*.java src\WarehouseAgentLauncher.java

java -cp "out;lib\jade.jar" WarehouseAgentLauncher
```

---

## 📷 Expected Output

```text
Order1 sent pick request.
Picker1 received: Please pick Item A
Packer1 received: Item A picked
Transport1 received: Item A packed and ready to ship
LOG: Manager received update — Item A delivered
```

---