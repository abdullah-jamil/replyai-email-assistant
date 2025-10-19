# ReplyAI 🤖✉️

An intelligent email response assistant powered by Google's Gemini API that seamlessly integrates with Gmail through a Chrome extension.

## 🌟 Overview

ReplyAI is a full-stack application that generates AI-powered email responses and integrates directly with Gmail using a Chrome extension.

## ✨ Key Features

- **Gmail Integration**: Seamless Chrome extension that adds a reply button directly to your Gmail interface
- **AI-Powered Responses**: Leverages Google's Gemini API for intelligent, context-aware email replies
- **One-Click Generation**: Generate professional email responses with a single click
- **Full-Stack Architecture**: Complete solution with Spring Boot backend and React frontend
- **Easy to Use**: Minimal setup required - install the extension and start replying smarter

## 🏗️ Architecture

ReplyAI consists of three main components:

### 1. **Chrome Extension** (Core Component)

The heart of ReplyAI - a lightweight Chrome extension that integrates directly into Gmail's interface, providing users with instant access to AI-powered reply suggestions.

### 2. **Backend - Spring Boot**

- RESTful API endpoints
- Gemini API integration
- Request handling and response processing
- Error handling and validation

### 3. **Frontend - React.js**

- Modern, responsive user interface
- Configuration and settings management
- User preferences and customization options

## 🚀 Getting Started

### Prerequisites

- Node.js (v14 or higher)
- Java JDK (v11 or higher)
- Maven
- Google Gemini API Key
- Chrome Browser

### Installation

#### 1. Clone the Repository

```bash
git clone https://github.com/yourusername/replyai.git
cd replyai
```

#### 2. Backend Setup (Spring Boot)

```bash
cd backend
# Add your Gemini API key to application.properties
# gemini.api.key=YOUR_API_KEY_HERE
mvn clean install
mvn spring-boot:run
```

#### 3. Frontend Setup (React)

```bash
cd frontend
npm install
npm start
```

#### 4. Chrome Extension Setup

```bash
cd chrome-extension
# Install dependencies if any
npm install
npm run build
```

**Load Extension in Chrome:**

1. Open Chrome and navigate to `chrome://extensions/`
2. Enable "Developer mode"
3. Click "Load unpacked"
4. Select the `chrome-extension/build` directory
5. The ReplyAI extension is now installed!

## 🔧 Configuration

### Backend Configuration

Update `application.properties` with your settings:

```properties
gemini.api.key=YOUR_GEMINI_API_KEY


## 💡 Usage

1. **Open Gmail** in your Chrome browser
2. **Navigate to any email** you want to reply to
3. **Click the ReplyAI button** that appears in the Gmail interface
4. **Review the AI-generated response** and make any desired edits
5. **Send your reply** with confidence!

## 🛠️ Technologies Used

- **Frontend**: React.js, JavaScript, HTML5, CSS3
- **Backend**: Spring Boot, Java
- **AI Integration**: Google Gemini API
- **Extension**: Chrome Extension APIs, Manifest V3
- **Build Tools**: Maven, npm/yarn

## 📂 Project Structure

```

replyai/
├── backend/
│ ├── src/
│ ├── pom.xml
│ └── application.properties
├── frontend/
│ ├── src/
│ ├── public/
│ └── package.json
├── chrome-extension/
│ ├── manifest.json
│ ├── content.js
│ ├── background.js
│ └── popup/
└── README.md

```

## 🔐 API Key Security

⚠️ **Important**: Never commit your Gemini API key to version control. Use environment variables or configuration files that are listed in `.gitignore`.

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

1. Fork the project
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request
```
