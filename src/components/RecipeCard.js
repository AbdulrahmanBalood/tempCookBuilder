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
  Button,
  SimpleGrid
} from '@chakra-ui/react';
import { Navigate,useParams,Link  } from "react-router-dom";
import RecipeContext from '../context/RecipeContext';
export const RecipeCard = () => {
  const {searchUrl,searchType,recipes, setRecipes} = useContext(RecipeContext)
  const [loadRecipes,setLoadRecipes] =useState(false);



  return (
    
        <Container height={['40rem','40rem']} maxW='6xl'>
      <SimpleGrid columns={[2,4]} spacing={10}>

        {recipes.map((recipe, index) => {
          return (
            <GridItem key={index}>
              <Image
                borderRadius="full"
                boxSize="150px"
                src={recipe.image}
              />
              <Link to={'/recipe/'+recipe.id}>
              <Text noOfLines={[1, 2, 3]} >{recipe.title}</Text>
              </Link>
            </GridItem>
          );
        })}
        </SimpleGrid>
      </Container>
    
  )
}
