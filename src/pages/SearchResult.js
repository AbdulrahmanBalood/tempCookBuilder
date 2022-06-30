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
  Spinner,
} from '@chakra-ui/react';
import { Navigate, useParams, Link } from 'react-router-dom';
import RecipeContext from '../context/RecipeContext';

export const SearchResult = () => {
  const { searchUrl, searchType } = useContext(RecipeContext);
  const [recipes, setRecipes] = useState([]);
  const [loadRecipes, setLoadRecipes] = useState(false);
  useEffect(() => {
  
      const getRecipes = async () => {
        console.log(searchUrl);
        const request = await fetch('http://localhost:8080' + searchUrl);
        console.log(request);
        const data = await request.json();
        setLoadRecipes(true)
        if (searchType === 'ByIngredient') {
          setRecipes(data);
        }
        if (searchType === 'ByCusine' || searchType === 'ByDiet') {
          setRecipes(data.results);
        }
      };
      getRecipes();
    
  }, []);

  return (
    <>
      <Flex justifyContent={'center'} alignItems="center" height={'100vh'}>
        {!loadRecipes ? (
          <Spinner
            thickness="4px"
            speed="0.65s"
            emptyColor="white"
            color="green.500"
            size="xl"
          />
        ) : (
          <VStack>
            <Container maxW="5xl">
              <Grid mt={'35rem'} gap={5} templateColumns="repeat(4, 1fr)">
                {recipes.map((recipe, index) => {
                  return (
                    <GridItem w="100%" mb={'13px'} key={index}>
                      <Image
                        borderRadius="full"
                        boxSize="150px"
                        src={recipe.image}
                      />
                      <Link to={'/recipe/' + recipe.id}>
                        <Text noOfLines={[1, 2, 3]}>{recipe.title}</Text>
                      </Link>
                    </GridItem>
                  );
                })}
              </Grid>
            </Container>
          </VStack>
        )}
      </Flex>
    </>
  );
};
