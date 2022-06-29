import { useState, useEffect, useContext } from 'react';
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
  Button,
} from '@chakra-ui/react';
import { Navigate, useParams, Link } from 'react-router-dom';
import RecipeContext from '../context/RecipeContext';
import { RecipeCard } from '../components/RecipeCard';

export const Home = () => {
  const { setSearchType, recipes, setRecipes } = useContext(RecipeContext);
  const [loadRecipes, setLoadRecipes] = useState(false);

  useEffect(() => {
    if (loadRecipes) {
      const getRecipes = async () => {
        const request = await fetch(
          'https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/random/?rapidapi-key=a6d0f4d8b2msh280a35f3b5593c5p1ce801jsn5c75cf02ac89&number=20'
        );
        const data = await request.json();
        console.log(data.recipes);
        setRecipes(data.recipes);
        setSearchType('homepage');
              
      };
      getRecipes();
    }
  }, [loadRecipes]);

  return (
    <>
      <Flex justifyContent={'center'} alignItems="center" height={'100vh'}>
        {!loadRecipes ? (
          <Button
            onClick={() => {
              setLoadRecipes(true);
            }}
          >
            Load recipes
          </Button>
        ) : (
          <RecipeCard />
        )}
      </Flex>
    </>
  );
};
