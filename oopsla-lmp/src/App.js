import React from 'react';
import { Link, Route, Routes, BrowserRouter } from "react-router-dom";

import Home from './Home';
import Sidebox from './Sidebox';
import Login from './Login';

export default function App() {
  return (
    //<Sidebox/>
    <Login/>
      // <div className="App">
      //     <BrowserRouter>
      //       <header>
      //         <Link to="/">
      //           <button>Home</button>
      //         </Link>
      //       </header>
      //       <hr />
      //       <main>
      //         <Routes>
      //           <Route path="/" element={<Home/>}></Route>
      //         </Routes>
      //       </main>
      //     </BrowserRouter>
      // </div>
  );
}