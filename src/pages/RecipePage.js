import React, { useEffect, useState } from 'react'
import { Navbar } from '../components/Navbar'
import { Navigate,useParams  } from "react-router-dom";
import {
    ChakraProvider,
    Box,
    Text,
    Link,
    VStack,
    HStack,
    Code,
    Grid,
    theme,
    Flex,
    Image,
    GridItem,
    Container,
    OrderedList,
    ListItem
  } from '@chakra-ui/react';
export const RecipePage = () => {
    let id = useParams();
const [recipe,setRecipe] = useState([])
const [ingredient,setIngredient] = useState([])
useEffect(()=>{
    const getRecipe = async()=> {
        const request = await fetch(`https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/${id.id}/information/?rapidapi-key=a6d0f4d8b2msh280a35f3b5593c5p1ce801jsn5c75cf02ac89`);
        const data = await request.json();
        setRecipe(data)
        console.log(data);
        setIngredient(data.extendedIngredients)
    }
    getRecipe()
    console.log(recipe.extendedIngredients);
},[])
  return (
    <>
    <Text>title: {recipe.title}</Text>
    <Text>diets: {recipe.diets}</Text>
    <Text>image: <Image src={recipe.image}></Image></Text>
    <Text>preparationMinutes: {recipe.preparationMinutes}</Text>
    <Text>cookingMinutes: {recipe.cookingMinutes}</Text>
    <Text>summary: {recipe.summary}</Text>
    <Text>instructions:{recipe.instructions}</Text>
    {/* <Text>analyzedInstructions:{recipe.analyzedInstructions}</Text> */}
    <OrderedList>
    {ingredient.map((ingredient,index)=>{
        return(
        <Container key={index}>
            <ListItem>
        <Text>{ingredient.name}</Text>
        <Text></Text>
        <Text>{ingredient.measures.metric.amount} {ingredient.measures.metric.unitLong}</Text>
        </ListItem>
        </Container>
        );
    })}
    </OrderedList>
    <Text></Text>
    </>
  )
}
