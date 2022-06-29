import { ColorModeScript } from '@chakra-ui/react';
import React, { StrictMode } from 'react';
import * as ReactDOM from 'react-dom/client';
import App from './App';
import {RecipeProvider} from './context/RecipeContext';
import { AuthProvider } from './context/AuthContext';



const container = document.getElementById('root');
const root = ReactDOM.createRoot(container);

root.render(
  <>
 
    <ColorModeScript />
    <AuthProvider>
    <RecipeProvider>
    <App />
    </RecipeProvider>
    </AuthProvider>
  </>
);


