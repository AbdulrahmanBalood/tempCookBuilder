import { useState, useEffect,useContext } from 'react';
import {
  ChakraProvider,
  Box,
  Text,
  
  VStack,
  HStack,
  Code,
  Grid,
  theme,
  Flex,
  Image,
  GridItem,
  Container,
  Button
} from '@chakra-ui/react';
import { Navigate,useParams,Link  } from "react-router-dom";
import RecipeContext from '../context/RecipeContext';
import { RecipeCard } from './RecipeCard';

export const Result = () => {
    const {searchUrl,searchType,recipes, setRecipes} = useContext(RecipeContext)
    const [loadRecipes,setLoadRecipes] =useState(false);
    useEffect(() => {
        if(loadRecipes){
        const getRecipes = async () => {
          const request = await fetch(
            searchUrl
          );
          const data = await request.json();
          if(searchType === "ByIngredient"){
          setRecipes(data);
          }
          if(searchType === "ByCusine"){
              setRecipes(data.results)
          }
        };
        getRecipes();
      }
       
      }, [loadRecipes]);
  return (
    <>
      
    <Flex justifyContent={'center'} alignItems="center" height={'100vh'}>
      {!loadRecipes? (<Button onClick={()=> {
        setLoadRecipes(true)
        
      }}>Load recipes</Button>):(
        <RecipeCard/>
      )}
    </Flex>
  </>
);
  
}
