import React, { useEffect, useState,useContext } from 'react';
import { Navbar } from '../components/Navbar';
import { Navigate, useParams } from 'react-router-dom';
import {
  ChakraProvider,
  Box,
  Text,
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
  Divider ,
  Button,
  Spinner
} from '@chakra-ui/react';
import RecipeContext from '../context/RecipeContext';
import { useNavigate,Link  } from "react-router-dom";
import AuthContext from '../context/AuthContext';

export const RecipePage = () => {
  let id = useParams();
  const Navigate = useNavigate()
  const { userID } = useContext(AuthContext);
  const {setSearchType,setSearchUrl,favoriteRecipesIDs} = useContext(RecipeContext)
  const [recipe, setRecipe] = useState([]);
  const [ingredient, setIngredient] = useState([]);
  const [dataRecived,setDataRecived] = useState(true);
  const [diet,setDiet] = useState('')
  const [instructions,setInstructions] = useState('')
  let newUrl = ''
  console.log(favoriteRecipesIDs);
  useEffect(() => {
    const getRecipe = async () => {
      const request = await fetch(
        `/api/v1/recipe/user/getrecipeinfo/${id.id}`
      );
      const data = await request.json();
      setRecipe(data);
      
      setIngredient(data.extendedIngredients);
      setDataRecived(false)
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
    return <Text fontWeight={'bold'} fontSize='3xl'>No Instructions avalible</Text>
  }
}
const favoriteOnClick = () => {
  const addFav = async()=> {
    let recipeID = id.id
    let urlRecipeTitle = recipe.title; 
    console.log(userID);
    const request = await fetch(`/api/v1/auth/userrecipe/favrecipe/${userID}/${recipeID}/${urlRecipeTitle}`,{
      method: 'PUT',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(userID,recipeID)
    })
    const data = await request.json();
    console.log(data);
  }
  addFav()

}
  
  return (
    <Flex justifyContent={'center'} alignItems='center' >
        {dataRecived ? ( <Spinner
            thickness="4px"
            speed="0.65s"
            emptyColor="white"
            color="green.500"
            size="xl"
          />):( <Container maxWidth={"3xl"}>
          <Text fontSize="5xl"> {recipe.title} <Button onClick={favoriteOnClick} marginLeft={"20%"} colorScheme='green'>add to favorite</Button></Text>
          <Stack  direction={['column', 'row']} spacing='10px'>
    
            {diet.map((diet,index)=> {
              
              return(
                <Badge  key={index} colorScheme="green"><Link onClick={() => {
                    let url = "/api/v1/recipe/recipes/findbydiet/"+diet
                    console.log(diet);
                    newUrl = url.replace(/ /g,'%20')
                    console.log(newUrl);
                    setSearchUrl(newUrl)
                    setSearchType("ByDiet")
                    Navigate('/result')
                  }}>{diet}</Link></Badge>
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
                
                  <ListItem key={index}>
                    <Text >
                    <strong>{ingredient.name} </strong>: {ingredient.measures.metric.amount}  {ingredient.measures.metric.unitLong}
                    </Text>
                   </ListItem>
    
                  
                
              );
            })}
          </OrderedList>
          <Text></Text>
        </Container>)}
   
    </Flex>
  );
};
