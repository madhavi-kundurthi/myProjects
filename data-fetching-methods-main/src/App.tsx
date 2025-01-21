import { QueryClient, QueryClientProvider } from '@tanstack/react-query';
import Home from './routes/home';
import { Route } from 'react-router-dom';
import React from 'react';
import ReactDOM from 'react-dom/client';
import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom';
const queryClient = new QueryClient();

export default function App() {

    return (
        <QueryClientProvider client={queryClient}>
       <Route path="/" element={<Home />} />
            </QueryClientProvider>
    );
}

export function renderToDOM(container) {
    const root = ReactDOM.createRoot(container);
    root.render(<App />);
  }