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


export const SearchResult = () => {
    const {searchUrl,searchType} = useContext(RecipeContext)
    const [recipes, setRecipes] = useState([]);
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
  