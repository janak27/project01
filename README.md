# **📝 Project01 - Note-Taking App**  

A simple **Note-Taking** web application built using **Spring Boot, JPA, and H2 Database**.  

---

## 🚀 **Features**  
✅ Create, Read, Update, and Delete (CRUD) notes  
✅ Store notes with **Title, Content, and Date**  
✅ RESTful APIs with JSON responses  
✅ Uses **Spring Boot + JPA + H2 Database**  
✅ Easy to integrate with **frontend frameworks**  

---

## 🏰 **Tech Stack**  
- **Backend**: Java, Spring Boot, Spring Data JPA  
- **Database**: H2 (In-Memory)  
- **Build Tool**: Maven  
- **Version Control**: Git & GitHub  

---

## ⚙️ **Installation & Setup**  

### **1⃣ Clone the Repository**  
```sh
git clone https://github.com/YOUR_GITHUB_USERNAME/project01.git
cd project01
```

### **2⃣ Run the Application**  
```sh
./mvnw spring-boot:run  # Linux/Mac  
mvnw.cmd spring-boot:run  # Windows  
```

> **The app runs at:** `http://localhost:8080`

---

## 📌 **API Endpoints**  

| Method | Endpoint | Description |
|--------|---------|-------------|
| **GET** | `/api/notes` | Get all notes |
| **GET** | `/api/notes/{id}` | Get note by ID |
| **POST** | `/api/notes` | Create a new note |
| **PUT** | `/api/notes/{id}` | Update a note |
| **DELETE** | `/api/notes/{id}` | Delete a note |

### **Example JSON for POST request**  
```json
{
  "title": "Meeting Notes",
  "content": "Discuss project updates and next steps."
}
```

---

## 💃 **Database Configuration (H2 Console)**  
- **URL**: `http://localhost:8080/h2-console`  
- **JDBC URL**: `jdbc:h2:mem:testdb`  
- **Username**: `sa`  
- **Password**: *(empty by default)*  

---

## 🎯 **To-Do & Future Enhancements**  
- ✅ Add **frontend** (React/Angular)  
- ⏳ Implement **JWT Authentication**  
- ⏳ Add **User Management (Login/Signup)**  

---

## 🐝 **License**  
This project is **MIT Licensed**. Feel free to use and modify!  

---

💡 **Contributions are welcome!** 🚀

