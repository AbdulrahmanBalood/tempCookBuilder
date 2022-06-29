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
export const RecipeCard = () => {
  const {searchUrl,searchType,recipes, setRecipes} = useContext(RecipeContext)
  const [loadRecipes,setLoadRecipes] =useState(false);



  return (
    <Flex justifyContent={'center'} alignItems="center" height={'100vh'}>
    
    <VStack>
        <Container maxW='5xl'>
      <Grid mt={'35rem'} gap={5}  templateColumns='repeat(4, 1fr)'>
        {recipes.map((recipe, index) => {
          // console.log();
          return (
            <GridItem w="100%" mb={'13px'} key={index}>
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
      </Grid>
      </Container>
    </VStack>
    
  </Flex>
  )
}
