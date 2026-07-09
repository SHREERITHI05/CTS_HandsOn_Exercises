import React from 'react';
import Post from './Post';

class Posts extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: []
    };
  }

  loadPosts() {
    fetch('https://jsonplaceholder.typicode.com/posts')
      .then((response) => response.json())
      .then((data) => {
        const postList = data.map(
          (item) => new Post(item.id, item.title, item.body)
        );
        this.setState({ posts: postList });
      })
      .catch((error) => {
        console.error('Error fetching posts:', error);
      });
  }

  componentDidMount() {
    this.loadPosts();
  }

  render() {
    return (
      <div style={{ textAlign: 'center', padding: '20px' }}>
        <h1>Blog Posts</h1>
        {this.state.posts.slice(0, 10).map((post) => (
          <div key={post.id} style={{ marginBottom: '20px' }}>
            <h3>{post.title}</h3>
            <p>{post.body}</p>
          </div>
        ))}
      </div>
    );
  }

  componentDidCatch(error, info) {
    alert('Something went wrong while loading posts: ' + error.message);
    console.error('Error caught in componentDidCatch:', error, info);
  }
}

export default Posts;