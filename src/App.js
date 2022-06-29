import React from 'react';
import {
  ChakraProvider,
  Box,
  Text,
  Link,
  VStack,
  HStack,
  Code,
  Grid,
  theme,
  Flex
} from '@chakra-ui/react';
import { ColorModeSwitcher } from './ColorModeSwitcher';
import { BrowserRouter,Route,Routes } from "react-router-dom";
import {Home} from './pages/Home'
import { RecipePage } from './pages/RecipePage';
import { Navbar } from './components/Navbar';
import { SearchPage } from './pages/SearchPage';
import { SearchResult } from './pages/SearchResult';
import Login from './pages/Login';
import Register from './pages/Register';

function App() {
  return (
    <ChakraProvider theme={theme}>
      <BrowserRouter>
      <Navbar></Navbar>
      <Routes>
        <Route path='/' element={<Home></Home>} />
        <Route path='/login' element={<Login/>}/>
        <Route path='/register' element={<Register/>}/>
        <Route path='/recipe/:id' element={<RecipePage/>}/>
        <Route path='/search' element={<SearchPage/>}/>
        <Route path='/result' element={<SearchResult/>}/>
      </Routes>
      </BrowserRouter>
    </ChakraProvider>
  );
}

export default App;
