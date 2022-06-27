import { useState, useEffect } from 'react';
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

export const Home = () => {
  const [recipes, setRecipes] = useState([]);
  useEffect(() => {
    const getRecipes = async () => {
      const request = await fetch(
        'https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/random/?rapidapi-key=a6d0f4d8b2msh280a35f3b5593c5p1ce801jsn5c75cf02ac89&number=20'
      );
      const data = await request.json();
      console.log(data.recipes);
      setRecipes(data.recipes);
    };
    getRecipes();
  }, []);


  return (
    <>
      
      <Flex justifyContent={'center'} alignItems="center" height={'100vh'}>
        <VStack>
            <Container maxW='5xl'>
          <Grid mt={'35rem'} gap={5}  templateColumns='repeat(4, 1fr)'>
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
                  <Text color={'gray'}>{recipe.dishTypes[0]}</Text>
                </GridItem>
              );
            })}
          </Grid>
          </Container>
        </VStack>
      </Flex>
    </>
  );
};
