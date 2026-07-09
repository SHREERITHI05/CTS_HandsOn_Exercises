import React, { useState } from "react";
import GuestPage from "./GuestPage";
import UserPage from "./UserPage";

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  const handleLogin = () => setIsLoggedIn(true);
  const handleLogout = () => setIsLoggedIn(false);

  // Element variable - decides which button to show
  let authButton;
  if (isLoggedIn) {
    authButton = <button onClick={handleLogout}>Logout</button>;
  } else {
    authButton = <button onClick={handleLogin}>Login</button>;
  }

  return (
    <div style={{ marginTop: "30px" }}>
      <div style={{ textAlign: "center", marginBottom: "20px" }}>
        {authButton}
      </div>

      {/* Conditional rendering - Guest vs User page */}
      {isLoggedIn ? <UserPage /> : <GuestPage />}
    </div>
  );
}

export default App;