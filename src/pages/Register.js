import React, { useContext, useState } from 'react';
import {
  Button,
  Flex,
  HStack,
  Image,
  Input,
  Link as ChakraLink,
  Text,
  VStack,
  useToast,
  FormControl,
  FormLabel,
  Alert,
  AlertIcon,
  AlertTitle,
  AlertDescription,
} from '@chakra-ui/react';
import { Link, useNavigate } from 'react-router-dom';
import AuthContext from '../context/AuthContext';

const Register = () => {
  const toast = useToast()
  const [username, setUsername] = useState('');
  const [email, setEmail] = useState('');
  const [confirmEmail, setConfirmEmail] = useState('');
  const [password, setPassword] = useState('');
  const [confirmPassword, setConfirmPassword] = useState('');
  const[passwordAlert,setPasswordAlert] = useState(false)
  const[emailAlert,setEmailAlert] = useState(false)
  const navigate = useNavigate();

  const { register } = useContext(AuthContext);

  const onClick = async () => {
    if(password != confirmPassword){
      setPasswordAlert(true)
    }
    if(email != confirmEmail){
      setEmailAlert(true)
    }
    const registerResult = await register(username, email, password);
    if (registerResult) {
      navigate('/login');
    }
  };
  const passAlert = ()=> {
  return(<Alert status='error'>
  <AlertIcon />
  <AlertTitle>Password not matching</AlertTitle>
  <AlertDescription></AlertDescription>
</Alert>)
  }
  const mailAlert = ()=> {
    return(<Alert status='error'>
    <AlertIcon />
    <AlertTitle>Email not matching</AlertTitle>
    <AlertDescription></AlertDescription>
  </Alert>)
  }
  return (
    <HStack spacing="0">
      <Flex
        height="100vh"
        width={'100%'}
        backgroundColor="white"
        alignItems="center"
        justifyContent="center"
      >
        <VStack width={['90%', '600px']} spacing="2rem">
          <Text fontWeight="bold" color="green.400" fontSize="70px">
            Welcome !
          </Text>
          {passwordAlert ? (passAlert()):(<></>)}
          {emailAlert ? (mailAlert()):(<></>)}
          <FormControl isRequired >
          <FormLabel htmlFor='first-name'>Username</FormLabel>
          <Input
            value={username}
            onChange={e => setUsername(e.target.value)}
            height="53px"
            placeholder="Username"
            type="text"
          ></Input>
           </FormControl>
           <FormControl isRequired>
          <FormLabel htmlFor='first-name'>Email</FormLabel>
          <Input
            value={email}
            onChange={e => setEmail(e.target.value)}
            height="53px"
            placeholder="Email"
            type="text"
          ></Input>
          </FormControl>
          <FormControl isRequired>
          <FormLabel htmlFor='first-name'>Confirm Email</FormLabel>
          <Input
            value={confirmEmail}
            onChange={e => setConfirmEmail(e.target.value)}
            height="53px"
            placeholder="Confirm Email"
            type="text"
          ></Input>
          </FormControl>
          <FormControl isRequired>
          <FormLabel htmlFor='first-name'>Password</FormLabel>
          <Input
            value={password}
            onChange={e => setPassword(e.target.value)}
            height="53px"
            placeholder="Password"
            type="password"
          ></Input>
           </FormControl>
           <FormControl isRequired>
          <FormLabel htmlFor='first-name'>Confirm Password</FormLabel>
          <Input
            value={confirmPassword}
            onChange={e => setConfirmPassword(e.target.value)}
            height="53px"
            placeholder="Confirm Password"
            type="password"
          ></Input>
         </FormControl>
          <Button
            fontSize="1.5rem"
            width="182px"
            onClick={onClick}
            backgroundColor="green.400"
            color="white"
          >
            Register
          </Button>
          <HStack fontSize="22px">
            <Text color="#A8A6AF">You have an account ? </Text>
            <Link to="/login">
              <Text color={'green.400'}>Login !</Text>
            </Link>
          </HStack>
        </VStack>
      </Flex>
    </HStack>
  );
};

export default Register;
