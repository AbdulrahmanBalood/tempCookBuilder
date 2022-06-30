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
    <Flex justifyContent={'center'} alignItems="center" height={'100vh'}>
    
    <VStack>
        <Container maxW='5xl'>
      {/* <Grid mt={['600%','30px']} gap={5}  templateColumns={['repeat(2)','repeat(2)','repeat(3)']}> */}
      <SimpleGrid columns={[2,4]} spacing={10}>

        {recipes.map((recipe, index) => {
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
        </SimpleGrid>
      {/* </Grid> */}
      </Container>
    </VStack>
    
  </Flex>
  )
}
