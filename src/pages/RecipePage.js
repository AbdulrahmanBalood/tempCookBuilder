import React, { useEffect, useState } from 'react';
import { Navbar } from '../components/Navbar';
import { Navigate, useParams } from 'react-router-dom';
import {
  ChakraProvider,
  Box,
  Text,
  Link,
  VStack,
  HStack,
  Stack,
  Code,
  Grid,
  theme,
  Flex,
  Image,
  GridItem,
  Container,
  OrderedList,
  ListItem,
  Badge,
  Divider 
} from '@chakra-ui/react';
export const RecipePage = () => {
  let id = useParams();
  const [recipe, setRecipe] = useState([]);
  const [ingredient, setIngredient] = useState([]);
  const [dataRecived,setDataRecived] = useState(false);
  const [diet,setDiet] = useState('')
  const [instructions,setInstructions] = useState('')

  useEffect(() => {
    const getRecipe = async () => {
      const request = await fetch(
        `https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/${id.id}/information/?rapidapi-key=a6d0f4d8b2msh280a35f3b5593c5p1ce801jsn5c75cf02ac89`
      );
      const data = await request.json();
      setRecipe(data);
      
      setIngredient(data.extendedIngredients);
      setDataRecived(true)
      setDiet(data.diets)
      setInstructions(data.instructions)
    };
   getRecipe();
    
  }, []);
  const instructionsData = () =>{
  if(instructions !== '' ){
    return (<>
    <Text fontWeight={'bold'} fontSize='3xl'>Instructions:</Text>
     {instructions} </>);
  }else{
    return 'No instructions avalible'
  }
}
  if(dataRecived)
  return (
    <Flex justifyContent={'center'} alignItems='center' >
    <Container maxWidth={"3xl"}>
      <Text fontSize="5xl"> {recipe.title}</Text>
      <Stack  direction={['column', 'row']} spacing='10px'>

        {diet.map((diet)=> {
          return(
            <Badge colorScheme="green">{diet}</Badge>
          )
        })}

      </Stack>
     
       <Image marginLeft={'5%'} borderRadius={'10px'} marginY='10px' src={recipe.image}></Image>
     
      {/* <Text>preparationMinutes: {recipe.preparationMinutes}</Text>
    <Text>cookingMinutes: {recipe.cookingMinutes}</Text> */}
    <Text fontWeight={'bold'} fontSize='3xl' >Summary</Text>
      <Text>{recipe.summary}
      </Text>
      <Divider orientation='horizontal' />
      
      
        <Text>
      {instructionsData()
      }
      </Text>
      {/* <Text>analyzedInstructions:{recipe.analyzedInstructions}</Text> */}
      <Divider orientation='horizontal' />
      <Text fontWeight={'bold'} fontSize='3xl'>Ingredients:</Text>
      <OrderedList>
        {ingredient.map((ingredient, index) => {
          return (
            < >
              <ListItem>
                <Text >
                <strong>{ingredient.name} </strong>: {ingredient.measures.metric.amount}  {ingredient.measures.metric.unitLong}
                </Text>
               </ListItem>

              
            </>
          );
        })}
      </OrderedList>
      <Text></Text>
    </Container>
    </Flex>
  );
};
