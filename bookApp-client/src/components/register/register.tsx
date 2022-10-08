import {authService} from './../../services/implements/auth.serviceImpl'
import Avatar from '@mui/material/Avatar';
import Button from '@mui/material/Button';
import CssBaseline from '@mui/material/CssBaseline';
import TextField from '@mui/material/TextField';
import CopyrightForm from '../shared/CopyrightForm';
import Link from '@mui/material/Link';
import Grid from '@mui/material/Grid';
import Box from '@mui/material/Box';
import {AccountBalance} from '@mui/icons-material/';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import {useState} from 'react'

  
const theme = createTheme();


  const Register= ():JSX.Element=>{
    const [formvalues,setFormValues]= useState({
      username:"",
      email:"",
      password:""
    })
    const handleChange=(event:React.ChangeEvent<HTMLInputElement|HTMLTextAreaElement>)=>{
      console.log(event.target.value)
      setFormValues(prev=>{return {...prev,[event.target.name]:event.target.value}})
    }


    const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();
        authService.signUp(formvalues,(e:any)=>{console.log(e)})
        setFormValues(prev=>{return{...prev,username:'',email:'',password:''}})
      };
    
      return (
        <ThemeProvider theme={theme}>
          <Container component="main" maxWidth="xs">
            <CssBaseline />
            <Box
              sx={{
                marginTop: 8,
                display: 'flex',
                flexDirection: 'column',
                alignItems: 'center',
              }}
            >
              <Avatar sx={{ m: 1, bgcolor: 'secondary.main' }}>
                <AccountBalance/>
              </Avatar>
              <Typography component="h1" variant="h5">
                Sign Up
              </Typography>
              <Box component="form" onSubmit={handleSubmit}  noValidate sx={{ mt: 1 }}>
              <TextField
                  margin="normal"
                  required
                  fullWidth
                  id="username"
                  label="Username"
                  name="username"
                  value={formvalues.username}
                  onChange={handleChange}
                  autoComplete="username"
                  autoFocus
                />
                <TextField
                  margin="normal"
                  required
                  fullWidth
                  id="email"
                  value={formvalues.email}
                  onChange={handleChange}
                  label="Email Address"
                  name="email"
                  autoComplete="email"
                  autoFocus
                />
                <TextField
                  margin="normal"
                  required
                  fullWidth
                  name="password"
                  label="Password"
                  value={formvalues.password}
                  onChange={handleChange}
                  type="password"
                  id="password"
                  autoComplete="current-password"
                />
              
                <Button
                  type="submit"
                  fullWidth
                  variant="contained"
                  sx={{ mt: 3, mb: 2 }}
                >
                  Sign Up
                </Button>
                <Grid container>
                  <Grid item xs>
                    <Link href="#" variant="body2">
                      
                    </Link>
                  </Grid>
                  <Grid item>
                    <Link href="/auth" variant="body2">
                      {"you are already registered? Sign In"}
                    </Link>
                  </Grid>
                </Grid>
              </Box>
            </Box>
            <CopyrightForm sx={{ mt: 8, mb: 4 }} />
          </Container>
        </ThemeProvider>
      );
}
export default Register
