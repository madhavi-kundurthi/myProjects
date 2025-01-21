import { useEffect, useState } from 'react';
import { getRequestWithNativeFetch } from '../lib/fetcherWithFetch';

const FetchGetRequest = () => {
  const [data, setData] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchDataForPosts = async () => {
      try {
        const postsData = await getRequestWithNativeFetch(
          'http://localhost:8080/api/customers'
        );
        setData(postsData);
        setError(null);
      } catch (err) {
        setError(err.message);
        setData(null);
      } finally {
        setLoading(false);
      }
    };

    fetchDataForPosts();
  }, []);

  return (
    <Box sx={{ height: 520, width: '100%' }}>

        <DataGridPro
          {...data &&
            data.map(( val ) => (
              <li
                key={val.id}
                className="border-b border-gray-100 text-sm sm:text-base"
              >
               {val.firstName}
               {val.lastName}
               {val.phoneNumber}
               
               
              {val.department.map(dept => dept.departmentName)}
               
              </li>

            
            ))}
    />
        </Box>
  );
};

export default FetchGetRequest;
