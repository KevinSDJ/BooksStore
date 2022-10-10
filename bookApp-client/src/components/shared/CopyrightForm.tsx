import {Link} from 'react-router-dom'




export default function Copyright(props: any) {
    return (
      <div>
        {'Copyright © '}
        <Link color="inherit" to={"https://www.google.com"} target={'_blank'}>
          bookmarket.com
        </Link>{' '}
        {new Date().getFullYear()}
        {'.'}
      </div>
    );
}