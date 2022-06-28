import { ColorModeScript } from '@chakra-ui/react';
import React, { StrictMode } from 'react';
import * as ReactDOM from 'react-dom/client';
import App from './App';
import {RecipeProvider} from './context/RecipeContext';



const container = document.getElementById('root');
const root = ReactDOM.createRoot(container);

root.render(
  <>
 
    <ColorModeScript />
    <RecipeProvider>
    <App />
    </RecipeProvider>
  </>
);


