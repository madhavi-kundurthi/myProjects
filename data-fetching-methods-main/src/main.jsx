import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';

import {
  createBrowserRouter
} from 'react-router-dom';
import Home from './routes/home.jsx';



const router = createBrowserRouter([
  {
    path: '/',
    element: <Home />,
 
  },
]);

// Create a client


ReactDOM.createRoot(document.getElementById('root')).render(

);
