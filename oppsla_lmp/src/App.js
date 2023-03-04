import Layout from "./Layout";
import Home from "./routes/Home";
import {
  createBrowserRouter,
  RouterProvider,
} from "react-router-dom";

function App(){
  const router = createBrowserRouter([
    {
      path: "/",
      element:
        <Layout />,
      children: [
        {
          path: "home",
          element: <Home />
        },
      ]
    },
  ]);
  
  return (
    <RouterProvider router={router} />
  )
};

export default App;import React from 'react';
import { BrowserRouter } from 'react-router-dom';
import App from './App';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <BrowserRouter>
    <App/>
  </BrowserRouter>
);